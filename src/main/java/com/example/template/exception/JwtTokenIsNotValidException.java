package com.example.NPKI.exception;

public class JwtTokenIsNotValidException extends RuntimeException {
    public JwtTokenIsNotValidException(String message) {
        super(message);
    }
}
