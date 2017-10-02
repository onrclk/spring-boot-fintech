package tr.com.fintech.config.interceptor;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import tr.com.fintech.common.JWTSecurityUtils;
import tr.com.fintech.common.SecurityUtils;

import java.io.IOException;
import java.util.Optional;


public class FintechHeaderRequestInterceptor implements ClientHttpRequestInterceptor {


    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest,
                                        byte[] bytes,
                                        ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        Optional
                .ofNullable(JWTSecurityUtils.getUserJWTToken())
                .ifPresent(authToken -> httpRequest.getHeaders().set(SecurityUtils.TOKEN_HEADER_NAME,authToken));

        return clientHttpRequestExecution.execute(httpRequest,bytes);
    }
}
