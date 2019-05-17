package com.stc.sns.visualization.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.stc.sns.visualization.security.AccountContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class JwtFactory {

    private static final Logger log = LoggerFactory.getLogger(JwtFactory.class);

    public final static String signingKey = "STC_JWT_TOKEN_KEY";

    public String generateToken(AccountContext context) {
        String token = null;

        try {
            token = JWT.create()
                    .withIssuer("STC")
                    .withClaim("USER_NAME", context.getAccount().getUserId())
//                    .withClaim("USER_ROLE", context.getAccount().getUserRole().getRoleName())
                    .sign(generateAlgorithm());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return token;
    }

    private Algorithm generateAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256(signingKey);
    }
}
