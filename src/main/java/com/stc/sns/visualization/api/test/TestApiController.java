package com.stc.sns.visualization.api.test;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class TestApiController {

    public String getUserName(Authentication authentication) {
        return "";
    }
}
