package com.dharmaraj.e_commerce.services;

import com.dharmaraj.e_commerce.custom_exceptions.OrderCannotBeCancelledException;
import com.dharmaraj.e_commerce.custom_exceptions.OrderDoesNotBelongToUserException;
import com.dharmaraj.e_commerce.custom_exceptions.OrderNotFoundException;
import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.models.Order;

public interface OrderService {
    
    public Order cancelOrder(int orderId, int userId)  throws UserNotFoundException, OrderNotFoundException, OrderDoesNotBelongToUserException, OrderCannotBeCancelledException;
}
