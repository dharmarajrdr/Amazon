package com.dharmaraj.e_commerce.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class LedgerEntry extends BaseModel{

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    
    private double amount;
    
    private Date createdAt;
}
