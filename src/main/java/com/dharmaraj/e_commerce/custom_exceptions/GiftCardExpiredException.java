package com.dharmaraj.e_commerce.custom_exceptions;

public class GiftCardExpiredException extends Exception{
    public GiftCardExpiredException(String message) {
        super(message);
    }
}
