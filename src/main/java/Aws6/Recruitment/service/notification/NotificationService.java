package Aws6.Recruitment.service.notification;

import Aws6.Recruitment.entity.notification.Notification;
import Aws6.Recruitment.entity.user.User;
import Aws6.Recruitment.repository.member.UserRepository;
import Aws6.Recruitment.repository.notification.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

//    @PreAuthorize("hasRole('USER')")
    public Notification createNotification(Long userId, String message) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Notification notification = Notification.builder()
                .user(user)
                .message(message)
                .createdAt(null)  // `createdAt`는 자동으로 설정됨
                .read(false)
                .build();

        return notificationRepository.save(notification);
    }

//    @PreAuthorize("hasRole('USER')")
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

//    @PreAuthorize("hasRole('USER')")
    public Notification markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setRead(true);
        return notificationRepository.save(notification);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

//    @PreAuthorize("hasRole('USER')")
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }

//    @PreAuthorize("hasRole('USER')")
    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
    }
}