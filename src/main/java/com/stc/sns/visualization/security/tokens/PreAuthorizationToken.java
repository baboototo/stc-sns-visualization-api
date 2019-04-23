package com.stc.sns.visualization.security.tokens;

import com.stc.sns.visualization.jpa.domain.user.Account;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 * 인증전
 */
public class PreAuthorizationToken extends UsernamePasswordAuthenticationToken {

    public PreAuthorizationToken(String username, String password) {
        super(username, password);
    }

    public PreAuthorizationToken(Account account) {
        super(account.getUserId(), account.getPassword());
    }

    public String getUsername() {
        return (String)super.getPrincipal();
    }

    public String getUserPassword() {
        return (String)super.getCredentials();
    }

}
