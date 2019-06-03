package com.stc.sns.visualization.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.stc.sns.visualization.security.exceptions.InvalidJwtException;
import com.stc.sns.visualization.util.DateUtils;
import jdk.nashorn.internal.runtime.options.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class JwtDecoder {

    private static final Logger log = LoggerFactory.getLogger(JwtDecoder.class);

    public String decodeJwt(String token) {
        try {
            DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new InvalidJwtException("유효한 토큰아 아닙니다."));

            this.isValidLicense(decodedJWT).orElseThrow(() -> new InvalidJwtException("유효한 라이센스가 아닙니다."));

            String username = decodedJWT.getClaim("USER_NAME").asString();

            log.info("decodeJwt : " + username);

            return username;

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

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


    private Optional<Boolean> isValidLicense(DecodedJWT decodedJWT) {
        boolean isLicense = false;

        Claim licenseStartClaim = decodedJWT.getClaim("LICENSE_S");
        Claim licenseEndClaim = decodedJWT.getClaim("LICENSE_E");

        if (!licenseStartClaim.isNull() && !licenseEndClaim.isNull()) {
            LocalDate licenseStart = DateUtils.asLocalDate(decodedJWT.getClaim("LICENSE_S").asDate());
            LocalDate licenseEnd = DateUtils.asLocalDate(decodedJWT.getClaim("LICENSE_E").asDate());

            LocalDate nowLocalDate = LocalDate.now();

            if (licenseStart.isAfter(nowLocalDate) && licenseEnd.isBefore(nowLocalDate)) {
                isLicense = true;
            }


            log.info("Token License Start : " + DateUtils.asDateString(licenseStart));
            log.info("Token License End   : " + DateUtils.asDateString(licenseEnd));
            log.info("Token License       : " + isLicense);
        }

        return Optional.ofNullable(isLicense);
    }
}
