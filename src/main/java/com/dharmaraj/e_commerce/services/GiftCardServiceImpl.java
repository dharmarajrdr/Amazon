package com.dharmaraj.e_commerce.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dharmaraj.e_commerce.custom_exceptions.GiftCardDoesntExistException;
import com.dharmaraj.e_commerce.custom_exceptions.GiftCardExpiredException;
import com.dharmaraj.e_commerce.models.GiftCard;
import com.dharmaraj.e_commerce.models.LedgerEntry;
import com.dharmaraj.e_commerce.models.TransactionType;
import com.dharmaraj.e_commerce.repositories.GiftCardRepository;
import com.dharmaraj.e_commerce.utils.GiftCardUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GiftCardServiceImpl implements GiftCardService {

    private final GiftCardRepository giftCardRepository;
    private final LedgerEntryService ledgerEntryService;

    @Override
    public GiftCard createGiftCard(double amount) {
        
        LedgerEntry ledgerEntry = new LedgerEntry();
        ledgerEntry.setAmount(amount);
        ledgerEntry.setCreatedAt(new Date());
        ledgerEntry.setTransactionType(TransactionType.CREDIT);
        ledgerEntry = ledgerEntryService.save(ledgerEntry);

        String giftCardCode = GiftCardUtils.generateGiftCardCode();
        Date now = new Date();
        Date expiresAt = GiftCardUtils.getExpirationDate(now);
        GiftCard giftCard = new GiftCard();
        giftCard.setAmount(amount);
        giftCard.setCreatedAt(now);
        giftCard.setExpiresAt(expiresAt);
        giftCard.setGiftCardCode(giftCardCode);
        giftCard.setLedger(List.of(ledgerEntry));
        return giftCardRepository.save(giftCard);
    }

    @Override
    public GiftCard redeemGiftCard(int giftCardId, double amountToRedeem) throws GiftCardDoesntExistException, GiftCardExpiredException {

        Optional<GiftCard> optionalGiftCard = giftCardRepository.findById(giftCardId);
        if(optionalGiftCard.isEmpty()){
            throw new GiftCardDoesntExistException("Gift card doesn't exist");
        }
        GiftCard giftCard = optionalGiftCard.get();
        Date now = new Date();
        if(now.after(giftCard.getExpiresAt())){
            throw new GiftCardExpiredException("Gift card expired");
        }
        amountToRedeem = Math.min(amountToRedeem, giftCard.getAmount());
        double remainingAmount = giftCard.getAmount() - amountToRedeem;
        LedgerEntry ledgerEntry = new LedgerEntry();
        ledgerEntry.setAmount(amountToRedeem);
        ledgerEntry.setCreatedAt(new Date());
        ledgerEntry.setTransactionType(TransactionType.DEBIT);
        ledgerEntry = ledgerEntryService.save(ledgerEntry);

        giftCard.setAmount(remainingAmount);
        giftCard.getLedger().add(ledgerEntry);
        return giftCardRepository.save(giftCard);
    }
    
}
