package Aws6.Recruitment.api.controller.application;

import Aws6.Recruitment.api.dto.application.ApplicationRequestDto;
import Aws6.Recruitment.entity.application.Application;
import Aws6.Recruitment.service.application.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<Application> applyForJob(@RequestBody ApplicationRequestDto applicationRequestDto) {
        Application application = applicationService.applyForJob(
                applicationRequestDto.getUserId(),
                applicationRequestDto.getJobPostingId(),
                applicationRequestDto.getResumeId()
        );
        return ResponseEntity.ok(application);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Application>> getApplicationsByUserId(@PathVariable("userId") Long userId) {
        List<Application> applications = applicationService.getApplicationsByUserId(userId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/job/{jobPostingId}")
    public ResponseEntity<List<Application>> getApplicationsByJobPostingId(@PathVariable("jobPostingId") Long jobPostingId) {
        List<Application> applications = applicationService.getApplicationsByJobPostingId(jobPostingId);
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id) {
        Application application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(application);
    }

    @GetMapping
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok("Application deleted successfully");
    }
}