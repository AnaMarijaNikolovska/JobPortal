package com.example.JobPortal.service.impl;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.amazonaws.services.s3.transfer.Upload;
import com.example.JobPortal.model.Application;
import com.example.JobPortal.model.JobPost;
import com.example.JobPortal.repository.ApplicationRepository;
import com.example.JobPortal.repository.JobPostRepository;
import com.example.JobPortal.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final JobPostRepository jobPostRepository;
    @Autowired
    private AmazonS3Client amazonS3Client;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository, JobPostRepository jobPostRepository) {
        this.applicationRepository = applicationRepository;
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public Application applyForJob(MultipartFile cvFile, String name, String email, String coverLetter, Long jobPostId) throws IOException {
        JobPost jobPost = jobPostRepository.findById(jobPostId).orElseThrow(() -> new EntityNotFoundException("Job post not found"));
        //TODO
        String cvUrl = uploadFileToS3(cvFile);
                //amazonS3Client.uploadFile(cvFile, jobPostId);
        Application application = new Application(jobPostId,name,email,coverLetter,cvUrl,jobPost);
        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();

    }

    @Override
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);

    }

    @Override
    public String uploadFileToS3(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        TransferManager transferManager = TransferManagerBuilder.standard().build();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        PutObjectRequest request = new PutObjectRequest("your-bucket-name", fileName, file.getInputStream(), metadata);
        Upload upload = transferManager.upload(request);
        try {
            upload.waitForCompletion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        transferManager.shutdownNow();
        return fileName;
    }
}