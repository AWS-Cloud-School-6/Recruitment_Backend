package Aws6.Recruitment.service.resume;

import Aws6.Recruitment.api.dto.resume.ResumeRequestDto;
import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.repository.jobposting.JobPostingRepository;
import Aws6.Recruitment.repository.resume.ResumeRepository;
import Aws6.Recruitment.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;
    private final JobPostingRepository jobPostingRepository;

//    @PreAuthorize("hasRole('USER')")
    public Resume createResume(ResumeRequestDto resumeRequestDto) {

        System.out.println(resumeRequestDto.getJobPostingId());
        System.out.println(resumeRequestDto.getUserId());

        JobPosting jobPosting = jobPostingRepository.findJobPostingById(resumeRequestDto.getJobPostingId());
        User user = userRepository.findUserById(resumeRequestDto.getUserId());

        System.out.println(jobPosting.getCompany());
        System.out.println(user.getUsername());

        Resume resume = Resume.builder()
                .jobPosting(jobPosting)
                .user(user)
                .name(resumeRequestDto.getName())
                .email(resumeRequestDto.getEmail())
                .phone(resumeRequestDto.getPhone())
                .summary(resumeRequestDto.getSummary())
                .education(resumeRequestDto.getEducation())
                .experience(resumeRequestDto.getExperience())
                .skills(resumeRequestDto.getSkills())
                .build();

        return resumeRepository.save(resume);
    }

//    @PreAuthorize("hasRole('USER')")
    public Resume updateResume(Long id, ResumeRequestDto updatedResume) {
        Resume existingResume = resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Resume resume = Resume.builder()
                .name(updatedResume.getName())
                .email(updatedResume.getEmail())
                .phone(updatedResume.getPhone())
                .summary(updatedResume.getSummary())
                .education(updatedResume.getEducation())
                .experience(updatedResume.getExperience())
                .skills(updatedResume.getSkills())
                .updatedAt(LocalDateTime.now())
                .build();


        return resumeRepository.save(resume);
    }

//    @PreAuthorize("hasRole('USER')")
    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }

//    @PreAuthorize("hasRole('USER')")
    public Resume getResumeById(Long id) {
        Resume resume_not_found = resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));
        return resume_not_found;
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    public List<Resume> getAllResumesByUser(User user) {
        return resumeRepository.findResumesByUser(user);
    }
}