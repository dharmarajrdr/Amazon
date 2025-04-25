package com.dharmaraj.e_commerce.controllers;

import com.dharmaraj.e_commerce.dtos.CancelOrderRequestDto;
import com.dharmaraj.e_commerce.dtos.CancelOrderResponseDto;
import com.dharmaraj.e_commerce.dtos.ResponseStatus;
import com.dharmaraj.e_commerce.models.Order;
import com.dharmaraj.e_commerce.services.OrderService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public CancelOrderResponseDto cancelOrder(CancelOrderRequestDto cancelOrderRequestDto) {

        CancelOrderResponseDto cancelOrderResponseDto = new CancelOrderResponseDto();
        try {
            Order order = this.orderService.cancelOrder(cancelOrderRequestDto.getOrderId(), cancelOrderRequestDto.getUserId());
            cancelOrderResponseDto.setOrder(order);
            cancelOrderResponseDto.setStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            cancelOrderResponseDto.setStatus(ResponseStatus.FAILURE);
        }
        return cancelOrderResponseDto;
    }

}
