package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepository;
import com.example.lab10.Repository.JobPostRepository;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JopApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final JobPostRepository postRepository;
    private final UserRepository userRepository;

    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    public void addJobApplication(JobApplication jobApplication) {
        if (postRepository.existsById(jobApplication.getJobPostId())
                && userRepository.existsById(jobApplication.getUserId())) {
            // If both exist, save the JobApplication
            jobApplicationRepository.save(jobApplication);
        } else {
            throw new IllegalArgumentException("Job post or user not found for given IDs.");
        }
    }

    public boolean updateJobApplication(Integer id,JobApplication jobApplication) {
        JobApplication update = jobApplicationRepository.getReferenceById(id);
        if (postRepository.existsById(jobApplication.getJobPostId())
                && userRepository.existsById(jobApplication.getUserId())) {
        if (update != null) {
            update.setUserId(update.getUserId());
            update.setJobPostId(update.getJobPostId());
            jobApplicationRepository.save(update);
            return true;
        }}
        return false;
    }

    public boolean deleteJobApplication(Integer id) {
        JobApplication delete = jobApplicationRepository.getReferenceById(id);
        if (delete != null) {
            jobApplicationRepository.delete(delete);
            return true;
        }
        return false;
    }
}
