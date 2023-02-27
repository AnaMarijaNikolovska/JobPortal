package com.example.JobPortal.service;

import com.example.JobPortal.model.JobPost;
import com.example.JobPortal.model.dto.JobPostDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface JobPostService {
    List<JobPost> findAllJobPosts();
    Optional<JobPost> findOneJobPost(Long id);
    List<JobPost> findAllJobPostsByCategory(String categoryId);
    List<JobPost> findAllJobPostsByIndustry(String industry);
    JobPost addJobPost(JobPostDto jobPostDto, MultipartFile picture) throws IOException;
    JobPost editJobPost(Long id, JobPostDto jobPostDto,MultipartFile picture) throws IOException;
    void deleteJobPost(Long id);
}
