package com.dharmaraj.e_commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.e_commerce.models.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    public Optional<Inventory> findInventoryByProductId(int productId);
    public Inventory save(Inventory inventory);
}
