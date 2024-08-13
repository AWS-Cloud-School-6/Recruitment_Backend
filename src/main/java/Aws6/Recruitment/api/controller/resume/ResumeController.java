package Aws6.Recruitment.api.controller.resume;

import Aws6.Recruitment.api.dto.jobposting.JobPostingResponseDto;
import Aws6.Recruitment.api.dto.resume.ResumeRequestDto;
import Aws6.Recruitment.api.dto.resume.ResumeResponseDto;
import Aws6.Recruitment.entity.response.CommonResult;
import Aws6.Recruitment.entity.response.ListResult;
import Aws6.Recruitment.entity.response.SingleResult;
import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.service.response.ResponseService;
import Aws6.Recruitment.service.resume.ResumeService;
import Aws6.Recruitment.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    private final ResponseService responseService;

    private final UserService userService;

    @PostMapping
    public CommonResult createResume(@RequestBody ResumeRequestDto resumeRequestDto) {
        resumeService.createResume(resumeRequestDto);
        return responseService.getSuccessResult();
    }

    @PutMapping("/{id}")
    public CommonResult updateResume(@PathVariable("id") Long id, @RequestBody ResumeRequestDto resumeRequestDto) {
        resumeService.updateResume(id,resumeRequestDto);
        return responseService.getSuccessResult();
    }

    @DeleteMapping("/{id}")
    public CommonResult deleteResume(@PathVariable("id") Long id) {
        resumeService.deleteResume(id);
        return responseService.getSuccessResult();
    }

//    @GetMapping("/{id}")
//    public SingleResult<ResumeResponseDto> getResumeById(@PathVariable("id") Long id) {
//        Resume resume = resumeService.getResumeById(id);
//        ResumeResponseDto resumeResponseDto = ResumeResponseDto.toDto(resume);
//        return responseService.getSingleResult(resumeResponseDto);
//    }

    @GetMapping
    public ListResult<ResumeResponseDto> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        List<ResumeResponseDto> resumeResponseDtoList = resumes.stream().map(ResumeResponseDto::toDto).collect(Collectors.toList());
        return responseService.getListResult(resumeResponseDtoList);
    }

    @GetMapping("/{userId}")
    public ListResult<ResumeResponseDto> getAllResumesByUser(@PathVariable("userId") Long id) {
        User user = userService.getUser(id);
        List<Resume> allResumesByUser = resumeService.getAllResumesByUser(user);
        List<ResumeResponseDto> resumeResponseDtoList = allResumesByUser.stream().map(ResumeResponseDto::toDto).collect(Collectors.toList());
        return responseService.getListResult(resumeResponseDtoList);
    }
}