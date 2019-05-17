package com.stc.sns.visualization.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.stc.sns.visualization.jpa.domain.user.Account;
import com.stc.sns.visualization.security.AccountContext;
import com.stc.sns.visualization.security.exceptions.InvalidJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtDecoder {

    private static final Logger log = LoggerFactory.getLogger(JwtDecoder.class);

    public String decodeJwt(String token) {
        try {
            DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new InvalidJwtException("유효한 토큰아 아닙니다."));
            String username = decodedJWT.getClaim("USER_NAME").asString();

            log.info("decodeJwt : " + username);

            return username;

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

//    public AccountContext decodeJwt(String token) {
//        try {
//            DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new InvalidJwtException("유효한 토큰아 아닙니다."));
//            String username = decodedJWT.getClaim("USER_NAME").asString();
//            String role = decodedJWT.getClaim("USER_ROLE").asString();
//
//            return new AccountContext(username, "1234", role);
//
//        }catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            return null;
//        }
//    }

    private Optional<DecodedJWT> isValidToken(String token) {

        DecodedJWT jwt = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(JwtFactory.signingKey);
            JWTVerifier verifier = JWT.require(algorithm).build();

            jwt = verifier.verify(token);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Optional.ofNullable(jwt);
    }

}
