package com.dharmaraj.e_commerce.dtos;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;
    private String password;
}
