package com.example.JobPortal.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {
    @NotBlank
    String name;
    @NotBlank
    String description;
    @NotBlank
    String mainCategory;
}
