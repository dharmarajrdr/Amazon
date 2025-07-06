package com.dharmaraj.e_commerce.dtos;

import com.dharmaraj.e_commerce.models.Advertisement;
import lombok.Data;

@Data
public class GetAdvertisementForUserResponseDto {
    private Advertisement advertisement;
    private ResponseStatus responseStatus;
}
