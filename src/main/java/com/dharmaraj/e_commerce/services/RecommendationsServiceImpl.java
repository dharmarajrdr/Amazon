package com.dharmaraj.e_commerce.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.models.Product;
import com.dharmaraj.e_commerce.models.ProductGroup;
import com.dharmaraj.e_commerce.repositories.ProductGroupsRepository;
import com.dharmaraj.e_commerce.repositories.ProductRepository;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {

    private final ProductRepository productRepository;
    private final ProductGroupsRepository productGroupsRepository;

    public RecommendationsServiceImpl(ProductRepository productRepository, ProductGroupsRepository productGroupsRepository) {
        this.productRepository = productRepository;
        this.productGroupsRepository = productGroupsRepository;
    }

    @Override
    public List<Product> getRecommendations(int productId) throws ProductNotFoundException {
        
        Product product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Product with id " + productId + " does not exist."));
        List<ProductGroup> list = productGroupsRepository.findAll();
        Set<Product> productSet = new HashSet<>();  // to avoid returning duplicates
        for (ProductGroup group : list) {
            if (group.getProducts().contains(product)) {
                productSet.addAll(group.getProducts());
            }
        }
        productSet.remove(product);
        return new ArrayList<>(productSet);
    }
    
}
