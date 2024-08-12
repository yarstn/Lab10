package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class JobPostController {
    private final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getJobPost() {
        return ResponseEntity.status(200).body(jobPostService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        jobPostService.add(jobPost);
        return ResponseEntity.status(201).body(new ApiResponse("jobPost added successfully"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJobPost( @PathVariable Integer id,@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        jobPostService.update(id, jobPost);
        return ResponseEntity.status(201).body(new ApiResponse("jobPost updated successfully"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id) {
        jobPostService.delete(id);
        return ResponseEntity.status(201).body(new ApiResponse("jobPost deleted successfully"));
    }
}
