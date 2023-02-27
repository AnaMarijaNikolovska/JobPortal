package com.example.JobPortal.repository;

import com.example.JobPortal.model.Account;
import com.example.JobPortal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Transactional
    List<Category> findAllCategoriesByIndustry(String industry);
}
