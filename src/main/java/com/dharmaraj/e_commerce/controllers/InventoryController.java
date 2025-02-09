package com.dharmaraj.e_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.custom_exceptions.UnAuthorizedAccessException;
import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.dtos.CreateOrUpdateRequestDto;
import com.dharmaraj.e_commerce.dtos.CreateOrUpdateResponseDto;
import com.dharmaraj.e_commerce.dtos.DeleteInventoryRequestDto;
import com.dharmaraj.e_commerce.dtos.DeleteInventoryResponseDto;
import com.dharmaraj.e_commerce.dtos.ResponseStatus;
import com.dharmaraj.e_commerce.models.Inventory;
import com.dharmaraj.e_commerce.services.InventoryService;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public CreateOrUpdateResponseDto createOrUpdateInventory(CreateOrUpdateRequestDto requestDto){
        CreateOrUpdateResponseDto createOrUpdateResponseDto = new CreateOrUpdateResponseDto();
        try {
            int userId = requestDto.getUserId();
            int productId = requestDto.getProductId();
            int quantity = requestDto.getQuantity();
            Inventory inventory = this.inventoryService.createOrUpdateInventory(userId, productId, quantity);
            createOrUpdateResponseDto.setInventory(inventory);
            createOrUpdateResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(ProductNotFoundException | UserNotFoundException | UnAuthorizedAccessException e) {
            createOrUpdateResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return createOrUpdateResponseDto;
    }

    public DeleteInventoryResponseDto deleteInventory(DeleteInventoryRequestDto requestDto){
        
        DeleteInventoryResponseDto deleteInventoryResponseDto = new DeleteInventoryResponseDto();
        try {
            int userId = requestDto.getUserId();
            int productId = requestDto.getProductId();
            this.inventoryService.deleteInventory(userId, productId);
            deleteInventoryResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(UserNotFoundException | UnAuthorizedAccessException e) {
            deleteInventoryResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return deleteInventoryResponseDto;
    }


}
