package com.dharmaraj.e_commerce.dtos;

import lombok.Data;

@Data
public class DeleteInventoryRequestDto {
    
    private int userId;
    private int productId;
}
