package tr.com.fintech.config.security.filter;

import org.apache.catalina.servlet4preview.GenericFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import tr.com.fintech.common.JwtUserToken;
import tr.com.fintech.common.SecurityUtils;
import tr.com.fintech.config.security.JwtAuthenticationToken;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

public class JWTTokenAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        Optional.ofNullable(getJWTToken(servletRequest))
                .ifPresent(authentication -> SecurityContextHolder
                        .getContext()
                        .setAuthentication(authentication));

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private Authentication getJWTToken(ServletRequest request) {
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        return Optional.ofNullable(servletRequest.getHeader(SecurityUtils.TOKEN_HEADER_NAME))
                .map(token -> new JwtAuthenticationToken(token.replace(SecurityUtils.TOKEN_HEADER_PREFIX, ""), null))
                .orElse(null);
    }
}
