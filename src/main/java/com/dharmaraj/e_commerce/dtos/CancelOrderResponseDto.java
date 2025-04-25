package com.dharmaraj.e_commerce.dtos;

import com.dharmaraj.e_commerce.models.Order;
import lombok.Data;

@Data
public class CancelOrderResponseDto {
    private ResponseStatus status;
    private Order order;
}
