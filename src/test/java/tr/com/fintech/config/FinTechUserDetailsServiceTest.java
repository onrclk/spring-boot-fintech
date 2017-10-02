package tr.com.fintech.config;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import tr.com.fintech.ApplicationConfiguration;
import tr.com.fintech.common.*;


import java.io.IOException;
import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
@WebAppConfiguration
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class FinTechUserDetailsServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(FinTechUserDetailsServiceTest.class);

    @Value("${fintech.login.url}")
    private String loginURL;

    @Value("${fintech.user.email}")
    private String email;

    @Value("${fintech.user.password}")
    private String password;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JWTSecurityUtils jwtSecurityUtils;


    @Test
    public void test_login() throws UnsupportedEncodingException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Login Request is being sent... : {} - {} - {}", loginURL, email, password);
        }

        Map<String, String> params = new HashMap<>();

        Optional
                .ofNullable(email)
                .ifPresent(s -> params.put(SecurityUtils.JWT_REQUEST_EMAIL_PARAM_NAME, s));

        Optional
                .ofNullable(password)
                .ifPresent(s -> params.put(SecurityUtils.JWT_REQUEST_PASSWORD_PARAM_NAME, s));

        ResponseEntity<MerchantJWTResponse> response = restTemplate.postForEntity(loginURL, params, MerchantJWTResponse.class);
        assertNotNull("response cannot be null", response);
        assertTrue("Response must be 200", response.getStatusCode() == HttpStatus.OK);

        MerchantJWTResponse result = response.getBody();
        assertTrue("must be approved", result.getStatus() == StatusType.APPROVED);
    }




    @Test
    public void test_login_convert_jwt() throws IOException {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Login Request is being sent... : {} - {} - {}", loginURL, email, password);
        }

        Map<String, String> params = new HashMap<>();

        Optional
                .ofNullable(email)
                .ifPresent(s -> params.put("email", s));

        Optional
                .ofNullable(password)
                .ifPresent(s -> params.put("password", s));

        ResponseEntity<MerchantJWTResponse> response = restTemplate.postForEntity(loginURL, params, MerchantJWTResponse.class);
        assertNotNull("response cannot be null", response);
        assertTrue("Response must be 200", response.getStatusCode() == HttpStatus.OK);

        MerchantJWTResponse result = response.getBody();
        assertTrue("must be approved", result.getStatus() == StatusType.APPROVED);

        assertNotNull("Token not null", result.getToken());
    }

}