package tr.com.fintech.config.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import tr.com.fintech.common.SecurityUtils;
import tr.com.fintech.common.UserCredentials;
import tr.com.fintech.config.security.JwtAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {


    public JWTLoginFilter(AntPathRequestMatcher urlMatcher,
                             AuthenticationManager authenticationManager) {
        super(urlMatcher);
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException,
            IOException, ServletException {

        UserCredentials userCredentials = new ObjectMapper()
                .readValue(req.getInputStream(), UserCredentials.class);

        return getAuthenticationManager()
                .authenticate(new UsernamePasswordAuthenticationToken(userCredentials.getUsername(),
                        userCredentials.getPassword(), Collections.emptyList()));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult)
            throws IOException, ServletException {


        if (authResult
                .getClass()
                .isAssignableFrom(JwtAuthenticationToken.class)) {
            JwtAuthenticationToken authToken = (JwtAuthenticationToken) authResult;
            response.addHeader(SecurityUtils.TOKEN_HEADER_NAME,
                    SecurityUtils.TOKEN_HEADER_PREFIX + " " + authToken.getToken());

        }
        // super.successfulAuthentication(request, response, chain, authResult);
    }
}
