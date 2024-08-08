package Aws6.Recruitment.entity.notification;

import Aws6.Recruitment.entity.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@RequiredArgsConstructor
@Getter
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private boolean read;

    @Builder
    public Notification(User user, String message, LocalDateTime createdAt, boolean read) {
        this.user = user;
        this.message = message;
        this.createdAt = createdAt;
        this.read = read;
    }
}
