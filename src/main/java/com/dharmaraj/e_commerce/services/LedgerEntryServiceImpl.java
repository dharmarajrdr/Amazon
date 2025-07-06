package com.dharmaraj.e_commerce.services;

import org.springframework.stereotype.Service;

import com.dharmaraj.e_commerce.models.LedgerEntry;
import com.dharmaraj.e_commerce.repositories.LedgerEntryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LedgerEntryServiceImpl implements LedgerEntryService {

    private final LedgerEntryRepository ledgerEntryRepository;

    @Override
    public LedgerEntry save(LedgerEntry ledgerEntry) {
        
        return ledgerEntryRepository.save(ledgerEntry);
    }
    
}
