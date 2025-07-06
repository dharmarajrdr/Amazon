package com.dharmaraj.e_commerce.controllers;

import com.dharmaraj.e_commerce.dtos.CreateGiftCardRequestDto;
import com.dharmaraj.e_commerce.dtos.CreateGiftCardResponseDto;
import com.dharmaraj.e_commerce.dtos.RedeemGiftCardRequestDto;
import com.dharmaraj.e_commerce.dtos.RedeemGiftCardResponseDto;
import com.dharmaraj.e_commerce.dtos.ResponseStatus;
import com.dharmaraj.e_commerce.models.GiftCard;
import com.dharmaraj.e_commerce.services.GiftCardService;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class GiftCardController {

    private final GiftCardService giftCardService;

    public CreateGiftCardResponseDto createGiftCard(CreateGiftCardRequestDto requestDto){
        
        CreateGiftCardResponseDto createGiftCardResponseDto = new CreateGiftCardResponseDto();
        GiftCard giftCard = giftCardService.createGiftCard(requestDto.getAmount());
        createGiftCardResponseDto.setGiftCard(giftCard);
        createGiftCardResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return createGiftCardResponseDto;
    }

    public RedeemGiftCardResponseDto redeemGiftCard(RedeemGiftCardRequestDto requestDto){
        
        RedeemGiftCardResponseDto redeemGiftCardResponseDto = new RedeemGiftCardResponseDto();
        try {
            GiftCard giftCard = giftCardService.redeemGiftCard(requestDto.getGiftCardId(), requestDto.getAmountToRedeem());
            redeemGiftCardResponseDto.setGiftCard(giftCard);
            redeemGiftCardResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception e) {
            redeemGiftCardResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return redeemGiftCardResponseDto;
    }
}
