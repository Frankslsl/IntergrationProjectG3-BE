package com.group3.finalprojectbe.system.dto;


import lombok.Getter;

@Getter
public class RegisterRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String email;
}
