package Aws6.Recruitment.entity.application;

import Aws6.Recruitment.entity.jobposting.JobPosting;
import Aws6.Recruitment.entity.resume.Resume;
import Aws6.Recruitment.entity.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "applications")
@RequiredArgsConstructor
@Getter
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_posting_id", nullable = false)
    private JobPosting jobPosting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(nullable = false)
    private LocalDateTime appliedAt;

    @Builder
    public Application(User user, JobPosting jobPosting, Resume resume, LocalDateTime appliedAt) {
        this.user = user;
        this.jobPosting = jobPosting;
        this.resume = resume;
        this.appliedAt = appliedAt;
    }
}
