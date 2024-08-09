package Aws6.Recruitment.service.jobposting;

import Aws6.Recruitment.api.dto.jobposting.JobPostingRequestDto;
import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.repository.jobposting.JobPostingRepository;
import Aws6.Recruitment.service.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostingService {

    private final JobPostingRepository jobPostingRepository;


//    @PreAuthorize("hasRole('ADMIN')")
    public JobPosting createJobPosting(JobPostingRequestDto jobPostingRequestDto) {
        JobPosting jobPosting = JobPosting.builder()
                .title(jobPostingRequestDto.getTitle())
                .description(jobPostingRequestDto.getDescription())
                .company(jobPostingRequestDto.getCompany())
                .location(jobPostingRequestDto.getLocation())
                .build();
        return jobPostingRepository.save(jobPosting);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public JobPosting updateJobPosting(Long id, JobPostingRequestDto updatedJobPosting) {
        JobPosting existingJobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job posting not found"));

        JobPosting jobPosting = JobPosting.builder()
                .title(updatedJobPosting.getTitle())
                .description(updatedJobPosting.getDescription())
                .company(updatedJobPosting.getCompany())
                .location(updatedJobPosting.getLocation())
                .build();

        return jobPostingRepository.save(jobPosting);
    }

    public void deleteJobPosting(Long id) {
        jobPostingRepository.deleteById(id);
    }

    public JobPosting getJobPostingById(Long id) {
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job posting not found"));
    }

    public List<JobPosting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }
}
