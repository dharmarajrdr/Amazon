package com.dharmaraj.e_commerce.services;

import com.dharmaraj.e_commerce.custom_exceptions.ProductNotFoundException;
import com.dharmaraj.e_commerce.models.Product;

import java.util.List;

public interface RecommendationsService {

    public List<Product> getRecommendations(int productId) throws ProductNotFoundException;
}
