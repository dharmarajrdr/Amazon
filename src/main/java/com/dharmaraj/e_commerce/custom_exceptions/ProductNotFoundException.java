package com.dharmaraj.e_commerce.custom_exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message) {
        super(message);
    }
}
