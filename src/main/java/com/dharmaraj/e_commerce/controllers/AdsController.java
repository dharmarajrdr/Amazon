package com.dharmaraj.e_commerce.controllers;

import org.springframework.stereotype.Controller;

import com.dharmaraj.e_commerce.dtos.GetAdvertisementForUserRequestDto;
import com.dharmaraj.e_commerce.dtos.GetAdvertisementForUserResponseDto;
import com.dharmaraj.e_commerce.dtos.ResponseStatus;
import com.dharmaraj.e_commerce.custom_exceptions.UserNotFoundException;
import com.dharmaraj.e_commerce.models.Advertisement;
import com.dharmaraj.e_commerce.services.AdsService;

@Controller
public class AdsController {

    private AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    public GetAdvertisementForUserResponseDto getAdvertisementForUser(GetAdvertisementForUserRequestDto requestDto) {
        GetAdvertisementForUserResponseDto getAdvertisementForUserResponseDto = new GetAdvertisementForUserResponseDto();
        try {
            int userId = requestDto.getUserId();
            Advertisement advertisement = this.adsService.getAdvertisementForUser(userId);
            getAdvertisementForUserResponseDto.setAdvertisement(advertisement);
            getAdvertisementForUserResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (UserNotFoundException e) {
            getAdvertisementForUserResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return getAdvertisementForUserResponseDto;
    }
}
