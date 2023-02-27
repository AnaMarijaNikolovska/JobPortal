package com.example.JobPortal.service.impl;

import com.example.JobPortal.model.Category;
import com.example.JobPortal.model.JobPost;
import com.example.JobPortal.model.dto.JobPostDto;
import com.example.JobPortal.repository.JobPostRepository;
import com.example.JobPortal.service.CategoryService;
import com.example.JobPortal.service.JobPostService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class JobPostServiceImpl implements JobPostService {
    private final JobPostRepository jobPostRepository;
    private final CategoryService categoryService;

    public JobPostServiceImpl(JobPostRepository jobPostRepository, CategoryService categoryService) {
        this.jobPostRepository = jobPostRepository;
        this.categoryService = categoryService;
    }

    @Override
    public List<JobPost> findAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @Override
    public Optional<JobPost> findOneJobPost(Long id) {
        return jobPostRepository.findById(id);
    }

    @Override
    public List<JobPost> findAllJobPostsByCategory(String categoryId) {
        return jobPostRepository.findAllJobPostsByCategory(categoryId);
    }

    @Override
    public List<JobPost> findAllJobPostsByIndustry(String industry) {
        return jobPostRepository.findAllJobPostsByIndustry(industry);
    }

    @Override
    public JobPost addJobPost(JobPostDto jobPostDto, MultipartFile picture) throws IOException {
        JobPost jobPost = new JobPost();
        if (picture != null) {
            jobPost.setPicture(picture.getBytes());
        }
        Optional<Category> optionalCategory = this.categoryService.getOneCategory(jobPostDto.getCategoryId());
        optionalCategory.ifPresent(jobPost::setCategory);
        mapDtoToEntity(jobPost, jobPostDto);
        return jobPostRepository.save(jobPost);
    }

    @Override
    public JobPost editJobPost(Long id, JobPostDto jobPostDto, MultipartFile picture) throws IOException {
        Optional<JobPost> jobPost = findOneJobPost(id);
        if (jobPost.isPresent()) {

            JobPost jobPost1 = jobPost.get();
            if (picture != null) {
                jobPost1.setPicture(picture.getBytes());
            }

            Optional<Category> optionalCategory = this.categoryService.getOneCategory(jobPostDto.getCategoryId());
            optionalCategory.ifPresent(jobPost1::setCategory);
            return jobPostRepository.save(jobPost1);
        }
        return null;
    }

    @Override
    public void deleteJobPost(Long id) {
        jobPostRepository.deleteById(id);
    }

    private void mapDtoToEntity(JobPost jobPost, JobPostDto jobPostDto) {
        jobPost.setTitle(jobPostDto.getTitle());
        jobPost.setDescription(jobPostDto.getDescription());
        jobPost.setDate(jobPostDto.getDate());
        jobPost.setPosition(jobPostDto.getPosition());
        jobPost.setQualifications(jobPostDto.getQualifications());
        jobPost.setNumberOfOpenPositions(jobPostDto.getNumberOfOpenPositions());
    }
}
