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
    String name;
    String surname;
    String phoneNumber;
    @NotBlank
    boolean isCompany;
    String aboutAccount;
    String companyName;
    String since;
}
