package Aws6.Recruitment.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="users")
@Getter
@Setter
@RequiredArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id", nullable = false)
        private Long id;

        @Column(nullable = false, unique = true)
        private String username;

        @Column(nullable = false)
        private String password;

        @Column(nullable = false)
        private String email;

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        private Role role;


}