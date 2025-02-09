package com.dharmaraj.e_commerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.dharmaraj.e_commerce.dtos.LoginRequestDto;
import com.dharmaraj.e_commerce.dtos.LoginResponseDto;
import com.dharmaraj.e_commerce.dtos.ResponseStatus;
import com.dharmaraj.e_commerce.dtos.SignupUserRequestDTO;
import com.dharmaraj.e_commerce.dtos.SignupUserResponseDTO;
import com.dharmaraj.e_commerce.models.User;
import com.dharmaraj.e_commerce.services.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupUserResponseDTO signupUser(SignupUserRequestDTO requestDTO) {
        SignupUserResponseDTO signupUserResponseDTO = new SignupUserResponseDTO();
        try {
            String name = requestDTO.getName();
            String email = requestDTO.getEmail();
            String password = requestDTO.getPassword();
            User user = this.userService.signupUser(name, email, password);
            signupUserResponseDTO.setEmail(email);
            signupUserResponseDTO.setName(name);
            signupUserResponseDTO.setResponseStatus(ResponseStatus.SUCCESS);
            signupUserResponseDTO.setUserId(user.getId());
        } catch (Exception e) {
            signupUserResponseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signupUserResponseDTO;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        try {
            String email = requestDto.getEmail();
            String password = requestDto.getPassword();
            boolean loggedIn = this.userService.login(email, password);
            loginResponseDto.setLoggedIn(loggedIn);
            loginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            loginResponseDto.setLoggedIn(false);
            loginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return loginResponseDto;
    }
}
