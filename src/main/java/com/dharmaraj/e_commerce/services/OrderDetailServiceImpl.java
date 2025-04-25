package com.dharmaraj.e_commerce.services;

import java.util.List;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.models.OrderDetail;
import com.dharmaraj.e_commerce.models.Product;
import com.dharmaraj.e_commerce.repositories.OrderDetailRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    private OrderDetailRepository orderDetailRepository;
    private InventoryService inventoryService;

    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository, InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.orderDetailRepository = orderDetailRepository;
    }

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
