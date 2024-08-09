package Aws6.Recruitment.api.controller.application;

import Aws6.Recruitment.api.dto.application.ApplicationRequestDto;
import Aws6.Recruitment.api.dto.application.ApplicationResponseDto;
import Aws6.Recruitment.api.dto.resume.ResumeResponseDto;
import Aws6.Recruitment.entity.application.Application;
import Aws6.Recruitment.entity.response.CommonResult;
import Aws6.Recruitment.entity.response.ListResult;
import Aws6.Recruitment.entity.response.SingleResult;
import Aws6.Recruitment.service.application.ApplicationService;
import Aws6.Recruitment.service.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    private final ResponseService responseService;

    @PostMapping("/apply")
    public CommonResult applyForJob(@RequestBody ApplicationRequestDto applicationRequestDto) {
        applicationService.applyForJob(applicationRequestDto);
        return responseService.getSuccessResult();
    }

    @GetMapping("/user/{userId}")
    public ListResult<ApplicationResponseDto> getApplicationsByUserId(@PathVariable("userId") Long userId) {
        List<Application> applications = applicationService.getApplicationsByUserId(userId);
        List<ApplicationResponseDto> applicationResponseDtoList = applications.stream().map(ApplicationResponseDto::toDto).collect(Collectors.toList());
        return responseService.getListResult(applicationResponseDtoList);
    }

    @GetMapping("/job/{jobPostingId}")
    public ListResult<ApplicationResponseDto> getApplicationsByJobPostingId(@PathVariable("jobPostingId") Long jobPostingId) {
        List<Application> applications = applicationService.getApplicationsByJobPostingId(jobPostingId);
        List<ApplicationResponseDto> applicationResponseDtoList = applications.stream().map(ApplicationResponseDto::toDto).collect(Collectors.toList());
        return responseService.getListResult(applicationResponseDtoList);
    }

    @GetMapping("/{id}")
    public SingleResult<ApplicationResponseDto> getApplicationById(@PathVariable("id") Long id) {
        Application application = applicationService.getApplicationById(id);
        ApplicationResponseDto applicationResponseDto = ApplicationResponseDto.toDto(application);
        return responseService.getSingleResult(applicationResponseDto);
    }

    @GetMapping
    public ListResult<ApplicationResponseDto> getAllApplications() {
        List<Application> applications = applicationService.getAllApplications();
        List<ApplicationResponseDto> applicationResponseDtoList = applications.stream().map(ApplicationResponseDto::toDto).collect(Collectors.toList());
        return responseService.getListResult(applicationResponseDtoList);
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return responseService.getSuccessResult();
    }
}