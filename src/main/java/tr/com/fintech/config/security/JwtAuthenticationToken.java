package tr.com.fintech.config.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import tr.com.fintech.common.StatusType;

import javax.validation.constraints.NotNull;
import java.util.Collection;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private String token;

    private StatusType status;

    public JwtAuthenticationToken(@NotNull String token,
                                  StatusType status) {
        super(AuthorityUtils.NO_AUTHORITIES);
        this.token = token;
        this.status = status;
    }

    public JwtAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
    }

    public String getToken() {
        return token;
    }

    public StatusType getStatus() {
        return status;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
