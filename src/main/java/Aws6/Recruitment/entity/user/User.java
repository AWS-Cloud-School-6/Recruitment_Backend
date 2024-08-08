package Aws6.Recruitment.entity.user;

import jakarta.persistence.*;


@Entity
@Table(name="users")
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

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

}