package com.dharmaraj.e_commerce.controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import com.dharmaraj.e_commerce.dtos.GenerateRecommendationsRequestDto;
import com.dharmaraj.e_commerce.dtos.GenerateRecommendationsResponseDto;
import com.dharmaraj.e_commerce.dtos.ResponseStatus;
import com.dharmaraj.e_commerce.models.Product;
import com.dharmaraj.e_commerce.services.RecommendationsService;

@RestController
@AllArgsConstructor
public class RecommendationsController {

    private final RecommendationsService recommendationsService;

    public GenerateRecommendationsResponseDto generateRecommendations(GenerateRecommendationsRequestDto requestDto) {
        
        GenerateRecommendationsResponseDto generateRecommendationsResponseDto = new GenerateRecommendationsResponseDto();
        try {
            List<Product> recommendations = recommendationsService.getRecommendations(requestDto.getProductId());
            generateRecommendationsResponseDto.setRecommendations(recommendations);
            generateRecommendationsResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch(Exception e) {
            generateRecommendationsResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return generateRecommendationsResponseDto;
    }
}
