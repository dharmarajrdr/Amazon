package com.dharmaraj.e_commerce.dtos;

import lombok.Data;

@Data
public class LoginResponseDto {

    private boolean loggedIn;
    private ResponseStatus responseStatus;
}
