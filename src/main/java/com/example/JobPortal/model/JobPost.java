package com.example.JobPortal.model;

import com.example.JobPortal.model.enums.Industry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String position;
    String description;
    String date;
    String qualifications;
    Integer numberOfOpenPositions;
    @ManyToOne
    Category category;
    @Lob
    byte[] picture;
    @Enumerated(value = EnumType.STRING)
    Industry industry;
}
