package com.dharmaraj.e_commerce.custom_exceptions;

public class GiftCardDoesntExistException extends Exception{
    public GiftCardDoesntExistException(String message) {
        super(message);
    }
}
