package tr.com.fintech;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import tr.com.fintech.config.interceptor.FintechHeaderRequestInterceptor;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "tr.com.fintech")
public class ApplicationConfiguration extends SpringBootServletInitializer {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfiguration.class);


    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ApplicationConfiguration.class);
    }

  /*  @Autowired
    public void configureMapper(ObjectMapper mapper) {
        mapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    }*/

    @Bean
    public RestTemplate restTemplate() throws NoSuchAlgorithmException, KeyManagementException {

        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, null);

        CloseableHttpClient httpClient = HttpClientBuilder
                .create()
                .setSSLContext(context)
                .build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);


        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Arrays.asList(new FintechHeaderRequestInterceptor()));
        return restTemplate;
    }
}
