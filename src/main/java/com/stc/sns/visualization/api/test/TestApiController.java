package com.stc.sns.visualization.api.test;

import com.stc.sns.visualization.security.tokens.PostAuthorizationToken;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestApiController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String getUsername(Authentication authentication) {

        PostAuthorizationToken token = (PostAuthorizationToken)authentication;

        return token.getAccountContext().getUsername();
    }
}
