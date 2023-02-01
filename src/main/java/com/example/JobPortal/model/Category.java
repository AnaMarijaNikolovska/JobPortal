package com.example.JobPortal.model;

import com.example.JobPortal.model.enums.MainCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    @Enumerated(value = EnumType.STRING)
    MainCategory mainCategory;
    @OneToMany
    List<JobPost> jobPostList;

}
