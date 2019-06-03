package com.stc.sns.visualization.security.providers;

import com.stc.sns.visualization.jpa.domain.user.Account;
import com.stc.sns.visualization.jpa.domain.user.AccountRepository;
import com.stc.sns.visualization.security.AccountContext;
import com.stc.sns.visualization.security.jwt.JwtDecoder;
import com.stc.sns.visualization.security.tokens.JwtPreProcessingToken;
import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private JwtDecoder jwtDecoder;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = (String)authentication.getPrincipal();
        String username = jwtDecoder.decodeJwt(token);
//        AccountContext context = jwtDecoder.decodeJwt(token);

        Account account = accountRepository.findByUserId(username).orElseThrow(() -> new NoSuchElementException("정보에 맞는 계정이 없습니다."));

        return PostAuthorizationToken.getTokenFromAccountContext(AccountContext.fromAccountModel(account));
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return JwtPreProcessingToken.class.isAssignableFrom(aClass);
    }
}
