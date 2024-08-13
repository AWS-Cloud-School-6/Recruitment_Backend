//package Aws6.Recruitment.api.dto.application;
//
//import Aws6.Recruitment.api.dto.jobposting.JobPostingResponseDto;
//import Aws6.Recruitment.api.dto.resume.ResumeResponseDto;
//import Aws6.Recruitment.api.dto.user.UserResponseDto;
////import Aws6.Recruitment.entity.application.Application;
//import lombok.Data;
//
//import java.time.LocalDateTime;
//
//@Data
//public class ApplicationResponseDto {
//
//    private UserResponseDto userResponseDto;
//    private JobPostingResponseDto jobPostingResponseDto;
//    private ResumeResponseDto resumeResponseDto;
//    private LocalDateTime appliedAt;
//
//    public ApplicationResponseDto(Application application) {
//        this.userResponseDto = UserResponseDto.toDto(application.getUser());
//        this.jobPostingResponseDto = JobPostingResponseDto.toDto(application.getJobPosting());
//        this.resumeResponseDto = ResumeResponseDto.toDto(application.getResume());
//        this.appliedAt = application.getAppliedAt();
//    }
//
//    public static ApplicationResponseDto toDto(Application application) {
//        return new ApplicationResponseDto(application);
//    }
//}
