package tr.com.fintech.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.com.fintech.common.JWTSecurityUtils;
import tr.com.fintech.common.JwtUserToken;

import java.util.Optional;

@RestController
@RequestMapping("/api/v3")
public class JwtUserController {

    private static final Logger LOG = LoggerFactory.getLogger(JwtUserController.class);

    @Autowired
    private JWTSecurityUtils jwtSecurityUtils;


    @GetMapping(value = "/activeUserToken",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtUserToken> getActivePrincipal() throws Exception {

        if (LOG.isDebugEnabled()) {
            LOG.debug("Active user is being asked ");
        }

        return Optional.ofNullable(jwtSecurityUtils.getCurrentJwtAuthentication())
                .map(jwtUserToken -> new ResponseEntity<>(jwtUserToken, HttpStatus.OK))
                .orElse(new ResponseEntity<JwtUserToken>(HttpStatus.UNAUTHORIZED));

    }
}
