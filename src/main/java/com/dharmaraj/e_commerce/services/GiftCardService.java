package com.dharmaraj.e_commerce.services;

import com.dharmaraj.e_commerce.custom_exceptions.GiftCardDoesntExistException;
import com.dharmaraj.e_commerce.custom_exceptions.GiftCardExpiredException;
import com.dharmaraj.e_commerce.models.GiftCard;

public interface GiftCardService {
    
    public GiftCard createGiftCard(double amount);

    public GiftCard redeemGiftCard(int giftCardId, double amountToRedeem) throws GiftCardDoesntExistException, GiftCardExpiredException;
}
