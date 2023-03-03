package com.example.JobPortal.controller;

import com.example.JobPortal.model.Application;
import com.example.JobPortal.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/application")
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public Application applyForJob(@RequestParam("cv") MultipartFile cvFile,
                                                   @RequestParam("name") String name,
                                                   @RequestParam("email") String email,
                                                   @RequestParam("coverLetter") String coverLetter,
                                                   @RequestParam("jobPostId") Long jobPostId) throws IOException {
        return applicationService.applyForJob(cvFile, name, email, coverLetter, jobPostId);
    }

    @GetMapping
    public List<Application> getApplications() {
        return applicationService.getApplications();
    }

    @DeleteMapping("{applicationId}")
    public void deleteApplication(@PathVariable Long applicationId) {
        applicationService.deleteApplication(applicationId);
    }
}
