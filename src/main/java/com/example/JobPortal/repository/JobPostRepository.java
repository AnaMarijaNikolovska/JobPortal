package com.example.JobPortal.repository;

import com.example.JobPortal.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost,Long> {
    @Transactional
    List<JobPost> findAllJobPostsByCategory(String categoryId);
    @Transactional
    List<JobPost> findAllJobPostsByMainCategory(String mainCategory);
}
