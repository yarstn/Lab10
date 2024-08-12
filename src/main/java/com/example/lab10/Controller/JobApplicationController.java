package com.example.lab10.Controller;
import com.example.lab10.ApiResponse.ApiResponse;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JopApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job")
public class JobApplicationController {
    private final JopApplicationService jopApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJobApplication() {
        return ResponseEntity.status(200).body(jopApplicationService.getAllJobApplications());
    }
    @PostMapping("/add")
    public ResponseEntity addJobApplication(@RequestBody@Valid JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        jopApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(201).body(new ApiResponse("Job Application Added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateJobApplication(@PathVariable int id, @RequestBody@Valid JobApplication jobApplication,Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getAllErrors());
        }
        jopApplicationService.updateJobApplication(id, jobApplication);
        return ResponseEntity.status(201).body(new ApiResponse("Job Application Updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable int id) {
        jopApplicationService.deleteJobApplication(id);
        return ResponseEntity.status(201).body(new ApiResponse("Job Application Deleted"));
    }
}
