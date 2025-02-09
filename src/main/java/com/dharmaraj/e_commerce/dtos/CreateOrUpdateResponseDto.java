package com.dharmaraj.e_commerce.dtos;

import com.dharmaraj.e_commerce.models.Inventory;
import lombok.Data;

@Data
public class CreateOrUpdateResponseDto {
    
    private Inventory inventory;
    private ResponseStatus responseStatus;
}
