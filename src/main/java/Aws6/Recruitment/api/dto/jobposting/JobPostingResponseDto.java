package Aws6.Recruitment.api.dto.jobposting;

import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.entity.user.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class JobPostingResponseDto {

    private String title;
    private String description;
    private String company;
    private String location;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;

    public JobPostingResponseDto(JobPosting jobPosting) {
        this.title = jobPosting.getTitle();
        this.description = jobPosting.getDescription();
        this.company = jobPosting.getCompany();
        this.location = jobPosting.getLocation();
        this.createAt = jobPosting.getCreatedAt();
        this.updatedAt = jobPosting.getUpdatedAt();
    }

    public static JobPostingResponseDto toDto(JobPosting jobPosting) {
        return new JobPostingResponseDto(jobPosting);
    }
}
