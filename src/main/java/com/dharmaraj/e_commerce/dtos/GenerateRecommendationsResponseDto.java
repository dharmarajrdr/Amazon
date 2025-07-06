package com.dharmaraj.e_commerce.dtos;

import com.dharmaraj.e_commerce.models.Product;
import lombok.Data;

import java.util.List;

@Data
public class GenerateRecommendationsResponseDto {

    private List<Product> recommendations;
    private ResponseStatus responseStatus;
}
