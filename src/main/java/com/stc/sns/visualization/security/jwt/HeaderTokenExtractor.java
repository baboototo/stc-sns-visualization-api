package com.stc.sns.visualization.security.jwt;

import com.stc.sns.visualization.security.exceptions.InvalidJwtException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * JWT Header Token 추출 Component
 */
@Component
public class HeaderTokenExtractor {

    public static final String HEADER_PREFIX = "Bearer ";

    public String extract(String header) {

        if(StringUtils.isEmpty(header) || header.length() < HEADER_PREFIX.length()) {
            throw new InvalidJwtException("올바른 토큰 정보가 아닙니다.");
        }

        return header.substring(HEADER_PREFIX.length(), header.length());
    }

}
