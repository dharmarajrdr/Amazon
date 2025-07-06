package com.dharmaraj.e_commerce.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class GiftCard extends BaseModel {

    private double amount;
    
    private Date createdAt;
    
    private Date expiresAt;
    
    @OneToMany(fetch = FetchType.EAGER)
    private List<LedgerEntry> ledger;
    
    private String giftCardCode;

    public boolean isExpired() {

        return expiresAt.before(new Date());
    }
}
