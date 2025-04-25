package com.dharmaraj.e_commerce.services;

import java.util.List;

import com.dharmaraj.e_commerce.custom_exceptions.OrderCannotBeCancelledException;
import com.dharmaraj.e_commerce.custom_exceptions.OrderDoesNotBelongToUserException;
import com.dharmaraj.e_commerce.custom_exceptions.OrderNotFoundException;
import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.models.Order;
import com.dharmaraj.e_commerce.models.OrderStatus;
import com.dharmaraj.e_commerce.models.User;
import com.dharmaraj.e_commerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final OrderDetailService orderDetailService;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, OrderDetailService orderDetailService) {
        this.userService = userService;
        this.orderRepository = orderRepository;
        this.orderDetailService = orderDetailService;
    }

    private Order getOrder(int orderId) throws OrderNotFoundException {

        return this.orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with order id " + orderId + " does not exist."));
    }

    private boolean canCancelOrder(Order order) {

        OrderStatus orderStatus = order.getOrderStatus();
        List<OrderStatus> cantCancelOrderIfStatus = List.of(OrderStatus.SHIPPED, OrderStatus.DELIVERED, OrderStatus.CANCELLED);
        return !cantCancelOrderIfStatus.contains(orderStatus);
    }

    @Override
    public Order cancelOrder(int orderId, int userId) throws UserNotFoundException, OrderNotFoundException, OrderDoesNotBelongToUserException, OrderCannotBeCancelledException {
        
        User user = userService.getUser(userId);
        Order order = getOrder(orderId);

        if(order.getUser().getId() != user.getId()) {
            throw new OrderDoesNotBelongToUserException("Order id " + orderId + " does not belong to user with user id " + userId);
        }

        if(!canCancelOrder(order)) {
            throw new OrderCannotBeCancelledException("Unable to cancel the order as the status of the order is " + order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.CANCELLED);

        orderDetailService.cancelOrders(order.getOrderDetails());

        return orderRepository.save(order);
    }
       
}
