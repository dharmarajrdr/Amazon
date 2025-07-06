package com.dharmaraj.e_commerce.dtos;

import com.dharmaraj.e_commerce.models.GiftCard;
import lombok.Data;

@Data
public class RedeemGiftCardResponseDto {
    private GiftCard giftCard;
    private ResponseStatus responseStatus;
}
