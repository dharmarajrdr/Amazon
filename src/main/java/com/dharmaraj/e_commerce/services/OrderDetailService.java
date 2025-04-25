package com.dharmaraj.e_commerce.services;

import java.util.List;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.models.OrderDetail;

public interface OrderDetailService {

    public void cancelOrder(OrderDetail orderDetail) throws ProductNotFoundException;
    
    public void cancelOrders(List<OrderDetail> orderDetails);
}
