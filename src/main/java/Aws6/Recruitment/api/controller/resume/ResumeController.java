package Aws6.Recruitment.api.controller.resume;

import Aws6.Recruitment.api.dto.resume.ResumeRequestDto;
import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.service.resume.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody ResumeRequestDto resumeRequestDto) {
        Resume createdResume = resumeService.createResume(resumeRequestDto);
        return ResponseEntity.ok(createdResume);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long id, @RequestBody Resume resume) {
        Resume updatedResume = resumeService.updateResume(id, resume);
        return ResponseEntity.ok(updatedResume);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteResume(@PathVariable Long id) {
        resumeService.deleteResume(id);
        return ResponseEntity.ok("Resume deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long id) {
        Resume resume = resumeService.getResumeById(id);
        return ResponseEntity.ok(resume);
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        List<Resume> resumes = resumeService.getAllResumes();
        return ResponseEntity.ok(resumes);
    }
}