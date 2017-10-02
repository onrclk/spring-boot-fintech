package tr.com.fintech.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import tr.com.fintech.config.security.JwtAuthenticationToken;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Optional;

@Service
public class JWTSecurityUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JWTSecurityUtils.class);

    @Autowired
    private ObjectMapper mapper;


    /**
     * method is used to split jwt token and convert
     * to pojo from body part
     *
     * @param jwt
     * @return
     * @throws IOException
     */
    public JwtUserToken convertJWTTo(@NotNull String jwt) throws IOException {

        DecodedJWT decoded = Optional
                .ofNullable(JWT.decode(jwt))
                .orElseThrow(() -> new RuntimeException("JWT Token could not be decoded"));

        String bodyAsJson = Optional.ofNullable(getJson(decoded.getPayload()))
                .orElseThrow(() -> new RuntimeException("JWT Token could not be parsed"));

        return Optional.ofNullable(mapper.readValue(bodyAsJson, JwtUserToken.class))
                .orElseThrow(() -> new RuntimeException("Given JWT Token is diverged: " + jwt));
    }


    public JwtUserToken getCurrentJwtAuthentication() {
        try {
            return convertJWTTo(getUserJWTToken());
        } catch (IOException e) {
            LOG.error("an error occured while converting jwt token to jwt auth token: ", e);
            throw new RuntimeException("an error occured while converting jwt token to jwt auth token: ");
        }
    }

    public static String getUserJWTToken() {
        Authentication authenticate = Optional.ofNullable(SecurityContextHolder
                .getContext()
                .getAuthentication())
                .orElse(null);

        return Optional
                .ofNullable(authenticate)
                .map(authentication -> ((JwtAuthenticationToken) authenticate).getToken()).orElse(null);

    }

    private static String getJson(String strEncoded) throws UnsupportedEncodingException {
        return StringUtils.newStringUtf8(Base64.decodeBase64(strEncoded));
    }

}
