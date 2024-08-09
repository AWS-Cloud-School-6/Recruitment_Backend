package Aws6.Recruitment.entity.user;

import Aws6.Recruitment.entity.resume.Resume;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity
@Table(name="users")
@Getter
@Setter
@RequiredArgsConstructor
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private Role role;

        @OneToMany(mappedBy = "user")  // 이력서와의 연관관계 설정
        private Set<Resume> resumes;  // 사용자가 가진 이력서들

}