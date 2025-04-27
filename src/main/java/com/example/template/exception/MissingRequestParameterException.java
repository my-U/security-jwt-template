package com.example.NPKI.exception;

public class MissingRequestParameterException extends RuntimeException {
    public MissingRequestParameterException(String message) {
        super(message);
    }
}
