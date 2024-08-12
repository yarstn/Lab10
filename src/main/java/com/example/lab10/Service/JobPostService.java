package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;
    public List<JobPost> findAll() {
        return jobPostRepository.findAll();
    }
    public void add(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }
    public boolean update(Integer id,JobPost jobPost) {
        JobPost findJobPost = jobPostRepository.getReferenceById(id);
        if(findJobPost != null) {
            findJobPost.setTitle(jobPost.getTitle());
            findJobPost.setDescription(jobPost.getDescription());
            findJobPost.setLocation(jobPost.getLocation());
            findJobPost.setSalary(jobPost.getSalary());
            jobPostRepository.save(findJobPost);
            return true;
        }
        return false;
    }
    public boolean delete(Integer id) {
        JobPost delete = jobPostRepository.getReferenceById(id);
        if(delete != null) {
            jobPostRepository.delete(delete);
            return true;
        }
        return false;
    }
}
