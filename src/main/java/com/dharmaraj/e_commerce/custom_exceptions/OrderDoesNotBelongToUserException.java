package com.dharmaraj.e_commerce.custom_exceptions;

public class OrderDoesNotBelongToUserException extends Exception {
    public OrderDoesNotBelongToUserException(String message) {
        super(message);
    }
}
