package com.dharmaraj.e_commerce.custom_exceptions;

public class OrderCannotBeCancelledException extends Exception {
    public OrderCannotBeCancelledException(String message) {
        super(message);
    }
}
