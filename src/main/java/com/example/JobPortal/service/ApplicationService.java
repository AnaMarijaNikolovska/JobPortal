package com.example.JobPortal.service;

import com.example.JobPortal.model.Application;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ApplicationService {
    Application applyForJob(MultipartFile cvFile, String name, String email, String coverLetter, Long jobPostId) throws IOException;
    List<Application> getApplications();
    void deleteApplication(Long applicationId);
    String uploadFileToS3(MultipartFile file) throws IOException;
}
