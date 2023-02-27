package com.example.JobPortal.controller;

import com.example.JobPortal.model.JobPost;
import com.example.JobPortal.model.dto.JobPostDto;
import com.example.JobPortal.service.JobPostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobPosts")
public class JobPostController {
    private final JobPostService jobPostService;

    public JobPostController(JobPostService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping
    public List<JobPost> findAllJobPosts() {
        return jobPostService.findAllJobPosts();
    }

    @GetMapping("/id")
    public Optional<JobPost> findOneJobPost(@PathVariable Long id){
        return jobPostService.findOneJobPost(id);
    }

    @GetMapping("/{categoryId}")
    public List<JobPost> findAllJobPostsByCategory(@PathVariable String categoryId){
        return jobPostService.findAllJobPostsByCategory(categoryId);
    }

    @GetMapping("/{industry}")
    public List<JobPost> findAllJobPostsByIndustry(@PathVariable String industry){
        return jobPostService.findAllJobPostsByIndustry(industry);
    }

    @PostMapping()
    public JobPost addJobPost(@RequestPart JobPostDto jobPostDto, @RequestPart MultipartFile picture)
            throws IOException{
        return jobPostService.addJobPost(jobPostDto,picture);
    }

    @PutMapping("/{id}")
    public JobPost editJobPost(@PathVariable Long id, @RequestPart JobPostDto jobPostDto,
                               @RequestPart MultipartFile picture) throws IOException{
        return jobPostService.editJobPost(id, jobPostDto, picture);
    }

    @DeleteMapping("/{id}")
    public void deleteJobPost(@PathVariable Long id){
        jobPostService.deleteJobPost(id);
    }
}
