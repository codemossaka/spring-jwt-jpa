package com.example.securityapp.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull
    @NotEmpty
    private String username;


    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;

}