package com.dharmaraj.e_commerce.custom_exceptions;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String message) {
        super(message);
    }
}
