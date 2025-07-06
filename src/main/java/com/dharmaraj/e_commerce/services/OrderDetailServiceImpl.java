package com.dharmaraj.e_commerce.services;

import java.util.List;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.models.OrderDetail;
import com.dharmaraj.e_commerce.models.Product;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final InventoryService inventoryService;

    public void cancelOrder(OrderDetail orderDetail) throws ProductNotFoundException {

        Product product = orderDetail.getProduct();
        int quantity = orderDetail.getQuantity();
        inventoryService.updateInventory(product, quantity);
    }

    @Override
    public void cancelOrders(List<OrderDetail> orderDetails) {

        for(OrderDetail orderDetail: orderDetails) {
            try {
                cancelOrder(orderDetail);
            } catch (ProductNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    
}
