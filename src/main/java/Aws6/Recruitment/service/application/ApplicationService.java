package Aws6.Recruitment.service.application;

import Aws6.Recruitment.entity.application.Application;
import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.repository.application.ApplicationRepository;
import Aws6.Recruitment.repository.jobposting.JobPostingRepository;
import Aws6.Recruitment.repository.member.UserRepository;
import Aws6.Recruitment.repository.resume.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final UserRepository userRepository;
    private final JobPostingRepository jobPostingRepository;
    private final ResumeRepository resumeRepository;

//    @PreAuthorize("hasRole('USER')")
    public Application applyForJob(Long userId, Long jobPostingId, Long resumeId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        JobPosting jobPosting = jobPostingRepository.findById(jobPostingId)
                .orElseThrow(() -> new RuntimeException("Job posting not found"));
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Application application = Application.builder()
                .user(user)
                .jobPosting(jobPosting)
                .resume(resume)
                .appliedAt(null)  // `appliedAt`는 자동으로 설정됨
                .build();

        return applicationRepository.save(application);
    }

//    @PreAuthorize("hasRole('USER')")
    public List<Application> getApplicationsByUserId(Long userId) {
        return applicationRepository.findByUserId(userId);
    }

//    @PreAuthorize("hasRole('USER')")
    public List<Application> getApplicationsByJobPostingId(Long jobPostingId) {
        return applicationRepository.findByJobPostingId(jobPostingId);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

//    @PreAuthorize("hasRole('USER')")
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }

//    @PreAuthorize("hasRole('USER')")
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
    }
}