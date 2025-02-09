package com.dharmaraj.e_commerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dharmaraj.e_commerce.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public Optional<Product> findProductById(int productId);
    public Product save(Product product);
    public void deleteAll();
}

