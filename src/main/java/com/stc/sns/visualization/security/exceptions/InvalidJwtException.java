package com.stc.sns.visualization.security.exceptions;

public class InvalidJwtException extends RuntimeException {

    public InvalidJwtException(String msg) {
        super(msg);
    }
}
