package com.example.JobPortal.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AccountDto {
    @NotBlank
    String username;
    @NotBlank
    String password;
    @NotBlank
    String mail;
    @NotBlank
    String name;
    @NotBlank
    String surname;
    String phoneNumber;
    @NotBlank
    boolean isCompany;
}
