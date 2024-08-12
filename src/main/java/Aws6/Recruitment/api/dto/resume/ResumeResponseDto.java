package Aws6.Recruitment.api.dto.resume;

import Aws6.Recruitment.entity.resume.Resume;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Data
public class ResumeResponseDto {

    private Long jobPostingId;
    private Long userId;

    private String name;
    private String email;
    private String phone;
    private String summary;
    private String education;
    private String experience;
    private String skills;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ResumeResponseDto(Resume resume) {
        this.jobPostingId=resume.getJobPosting().getId();
        this.userId=resume.getUser().getId();
        this.name = resume.getName();
        this.email = resume.getEmail();
        this.phone = resume.getPhone();
        this.summary = resume.getSummary();
        this.education = resume.getEducation();
        this.experience = resume.getExperience();
        this.skills = resume.getSkills();
        this.createdAt = getCreatedAt();
        this.updatedAt = resume.getUpdatedAt();
    }

    public static ResumeResponseDto toDto(Resume resume) {
        return new ResumeResponseDto(resume);
    }
}
