package com.stc.sns.visualization.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.stc.sns.visualization.security.AccountContext;
import com.stc.sns.visualization.util.DateUtils;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Component
public class JwtFactory {

    private static final Logger log = LoggerFactory.getLogger(JwtFactory.class);

    public final static String signingKey = "STC_JWT_TOKEN_KEY";

    public String generateToken(AccountContext context) {
        String token = null;


        LocalDate localDate = LocalDate.now();
//        String startDate = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        String endDate = localDate.minusDays(1).plusYears(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//        log.info(startDate + " : " + endDate);

        try {
            token = JWT.create()
                    .withIssuer("STC")
                    .withClaim("USER_NAME", context.getAccount().getUserId())
//                    .withClaim("LICENSE_S", DateUtils.asDate(localDate.plusDays(10)))
//                    .withClaim("LICENSE_E", DateUtils.asDate(localDate.plusDays(9).plusYears(1)))

                    .withClaim("LICENSE_S", DateUtils.asDate(localDate))
                    .withClaim("LICENSE_E", DateUtils.asDate(localDate.minusDays(1).plusYears(1)))
//                    .withClaim("START_DATE", Date.valueOf(LocalDate.of(2015, 5, 5)))
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
