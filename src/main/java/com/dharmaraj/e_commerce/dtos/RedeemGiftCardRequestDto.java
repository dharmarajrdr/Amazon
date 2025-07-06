package com.dharmaraj.e_commerce.dtos;

import lombok.Data;

@Data
public class RedeemGiftCardRequestDto {
    private double amountToRedeem;
    private int giftCardId;
}
