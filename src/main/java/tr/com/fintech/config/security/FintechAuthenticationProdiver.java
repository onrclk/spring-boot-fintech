package tr.com.fintech.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.client.RestTemplate;
import tr.com.fintech.common.MerchantJWTResponse;
import tr.com.fintech.common.SecurityUtils;
import tr.com.fintech.common.StatusType;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class FintechAuthenticationProdiver implements AuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(FintechAuthenticationProdiver.class);

    @Value("${fintech.login.url}")
    private String loginURL;

    @Value("${fintech.jwt.secketKey:#{null}}")
    private String jwtSecretKey;


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {


        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            return getJwtAuthenticationToken((UsernamePasswordAuthenticationToken) authentication);

        } else if (authentication instanceof JwtAuthenticationToken) {
            return getJwtAuthenticationToken((JwtAuthenticationToken) authentication);

        } else {
            LOG.error("Unsupported authentication type : {}", authentication.getClass().getName());
            throw new RuntimeException("Unsupported authentication type : " + authentication.getClass().getName());
        }

    }

    private Authentication getJwtAuthenticationToken(UsernamePasswordAuthenticationToken authentication) {

        String email = Optional
                .ofNullable(authentication.getPrincipal())
                .map(o -> (String) o)
                .orElseThrow(() -> new RuntimeException("User cannot login without principal"));

        String password = Optional
                .ofNullable(authentication.getCredentials())
                .map(o -> (String) o)
                .orElseThrow(() -> new RuntimeException("User cannot login without credentials"));

        Map<String, String> requestParams = new HashMap<>();
        requestParams.put(SecurityUtils.JWT_REQUEST_EMAIL_PARAM_NAME, email);
        requestParams.put(SecurityUtils.JWT_REQUEST_PASSWORD_PARAM_NAME, password);


        MerchantJWTResponse response = Optional.ofNullable(restTemplate
                .postForEntity(loginURL, requestParams, MerchantJWTResponse.class))
                .map(merchantJWTResponseResponseEntity -> merchantJWTResponseResponseEntity.getBody())
                .orElseThrow(() -> new RuntimeException("an error occured while requesting jwt token for User : " + email));

        if (response.getStatus() != StatusType.APPROVED) {
            LOG.error("Received Token is not valid for token provider user: {} , token : {}", email, response.getStatus());
            throw new InsufficientAuthenticationException("Received Token is not valid for token provider user: " + email
                    + " status: " + response.getStatus());
        }
        return new JwtAuthenticationToken(response.getToken(), response.getStatus());

        // for test purposes

      /*  String result = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJtZXJjaGFudFVzZXJJZCI6NTMsInJvbGUiOiJ1c2VyIiwibWVyY2hhbnRJZCI6Mywic3ViTWVyY2hhbnRJZHMiOlszLDc0LDkzLDExOTEsMTExLDEzNywxMzgsMTQyLDE0NSwxNDYsMTUzLDMzNCwxNzUsMTg0LDIyMCwyMjEsMjIyLDIyMywyOTQsMzIyLDMyMywzMjcsMzI5LDMzMCwzNDksMzkwLDM5MSw0NTUsNDU2LDQ3OSw0ODgsNTYzLDExNDksNTcwLDExMzgsMTE1NiwxMTU3LDExNTgsMTE3OV0sInRpbWVzdGFtcCI6MTUwNjYzMTE1OH0.T_RKEmH_arLPR5b4X0K8Q7Wikcm5UXwjEtMoCFKOrJM";
        return new JwtAuthenticationToken(result, StatusType.APPROVED);*/
    }

    /**
     * if secket key is given, we can verify jwt token here
     * and also check whether its expired
     *
     * @param jwtAuthenticationToken
     * @return
     */
    private Authentication getJwtAuthenticationToken(JwtAuthenticationToken jwtAuthenticationToken) {
        String jwtToekn = jwtAuthenticationToken.getToken();

        if (Objects.nonNull(jwtSecretKey)) {
            try {
                JWTVerifier verify = JWT.require(Algorithm.HMAC256(jwtSecretKey))
                        .build();
                verify.verify(jwtToekn);

            } catch (UnsupportedEncodingException e) {
                LOG.error("JWT Token is not valid  ", e);
                throw new RuntimeException("Token has invalid encoding " + e.getLocalizedMessage());
            }

        }

        return jwtAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(UsernamePasswordAuthenticationToken.class)
                || aClass.isAssignableFrom(JwtAuthenticationToken.class);
    }
}
