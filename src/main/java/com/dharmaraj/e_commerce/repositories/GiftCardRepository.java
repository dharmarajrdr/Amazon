package com.dharmaraj.e_commerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.e_commerce.models.GiftCard;

@Repository
public interface GiftCardRepository extends JpaRepository<GiftCard, Integer> {

}
