package Aws6.Recruitment.api.controller.jobposting;

import Aws6.Recruitment.api.dto.jobposting.JobPostingRequestDto;
import Aws6.Recruitment.api.dto.jobposting.JobPostingResponseDto;
import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.entity.response.CommonResult;
import Aws6.Recruitment.entity.response.ListResult;
import Aws6.Recruitment.entity.response.SingleResult;
import Aws6.Recruitment.service.jobposting.JobPostingService;
import Aws6.Recruitment.service.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/job-postings")
@RequiredArgsConstructor
public class JobPostingController {

    private final JobPostingService jobPostingService;

    private final ResponseService responseService;

    @PostMapping
    public CommonResult createJobPosting(@RequestBody JobPostingRequestDto jobPostingRequestDto) {
        JobPosting createdJobPosting = jobPostingService.createJobPosting(jobPostingRequestDto);
        return responseService.getSuccessResult();
    }

    @PutMapping("/{id}")
    public CommonResult updateJobPosting(@PathVariable Long id, @RequestBody JobPostingRequestDto jobPostingRequestDto) {
        JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPostingRequestDto);
        return responseService.getSuccessResult();
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteJobPosting(@PathVariable Long id) {
        jobPostingService.deleteJobPosting(id);
        return responseService.getSuccessResult();
    }

    @GetMapping("/{id}")
    public SingleResult<JobPostingResponseDto> getJobPostingById(@PathVariable Long id) {
        JobPosting jobPosting = jobPostingService.getJobPostingById(id);
        JobPostingResponseDto jobPostingResponseDto = JobPostingResponseDto.toDto(jobPosting);
        return responseService.getSingleResult(jobPostingResponseDto);
    }

    @GetMapping
    public ListResult<JobPostingResponseDto> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        List<JobPostingResponseDto> jobPostingResponseDtoList = jobPostings.stream().map(JobPostingResponseDto::toDto).collect(Collectors.toList());
        return responseService.getListResult(jobPostingResponseDtoList);
    }
}