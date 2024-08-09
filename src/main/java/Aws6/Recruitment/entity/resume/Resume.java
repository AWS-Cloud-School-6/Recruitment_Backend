package Aws6.Recruitment.entity.resume;

import Aws6.Recruitment.entity.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
@Getter
@RequiredArgsConstructor
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String summary;

    @Column(nullable = false)
    private String education;

    @Column(nullable = false)
    private String experience;

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)  // 연관관계 설정
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 이력서와 사용자 간의 연관관계
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    @Builder
    public Resume(String name, String email, String phone, String summary, String education, String experience, String skills, User user) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.summary = summary;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
        this.user = user;
    }
}


