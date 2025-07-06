package com.dharmaraj.e_commerce.dtos;

import com.dharmaraj.e_commerce.models.GiftCard;
import lombok.Data;

@Data
public class CreateGiftCardResponseDto {
    private GiftCard giftCard;
    private ResponseStatus responseStatus;
}
