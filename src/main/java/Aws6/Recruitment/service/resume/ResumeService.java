package Aws6.Recruitment.service.resume;

import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.repository.resume.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

//    @PreAuthorize("hasRole('USER')")
    public Resume createResume(Resume resume) {
        return resumeRepository.save(resume);
    }

//    @PreAuthorize("hasRole('USER')")
    public Resume updateResume(Long id, Resume updatedResume) {
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
                .build();


        return resumeRepository.save(resume);
    }

//    @PreAuthorize("hasRole('USER')")
    public void deleteResume(Long id) {
        resumeRepository.deleteById(id);
    }

//    @PreAuthorize("hasRole('USER')")
    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }
}