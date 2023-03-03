package com.example.JobPortal.model;

import com.example.JobPortal.model.enums.Industry;
import com.example.JobPortal.model.enums.JobType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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
    String salery;
    @Lob
    byte[] picture;
    @ManyToOne
    Category category;
    @OneToMany
    List<Application> applications;
    @Enumerated(value = EnumType.STRING)
    Industry industry;
    @Enumerated(value = EnumType.STRING)
    JobType jobType;
}
