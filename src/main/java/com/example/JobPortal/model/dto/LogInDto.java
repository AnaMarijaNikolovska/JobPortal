package com.example.JobPortal.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LogInDto {
    @NotBlank
    String username;
    @NotBlank
    String password;

}
