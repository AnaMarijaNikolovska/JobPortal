package com.example.JobPortal.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class JobPostDto {
    @NotBlank
    String title;

    @NotBlank
    String position;
    String description;
    String date;
    String qualifications;
    Integer numberOfOpenPositions;
    @NotNull
    Long categoryId;
    Long mainCategoryId;

}
