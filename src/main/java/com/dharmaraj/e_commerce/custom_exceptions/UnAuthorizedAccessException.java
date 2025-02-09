package com.dharmaraj.e_commerce.custom_exceptions;

public class UnAuthorizedAccessException extends Exception {

    public UnAuthorizedAccessException(String message) {
        super(message);
    }
}
