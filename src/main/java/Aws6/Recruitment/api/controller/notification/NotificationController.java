//package Aws6.Recruitment.api.controller.notification;
//
//import Aws6.Recruitment.entity.notification.Notification;
//import Aws6.Recruitment.service.notification.NotificationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/notifications")
//@RequiredArgsConstructor
//public class NotificationController {
//
//    private final NotificationService notificationService;
//
//    @PostMapping
//    public ResponseEntity<Notification> createNotification(@RequestParam Long userId,
//                                                           @RequestParam String message) {
//        Notification notification = notificationService.createNotification(userId, message);
//        return ResponseEntity.ok(notification);
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable Long userId) {
//        List<Notification> notifications = notificationService.getNotificationsByUserId(userId);
//        return ResponseEntity.ok(notifications);
//    }
//
//    @PutMapping("/{id}/read")
//    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
//        Notification notification = notificationService.markAsRead(id);
//        return ResponseEntity.ok(notification);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<Notification>> getAllNotifications() {
//        List<Notification> notifications = notificationService.getAllNotifications();
//        return ResponseEntity.ok(notifications);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteNotification(@PathVariable Long id) {
//        notificationService.deleteNotification(id);
//        return ResponseEntity.ok("Notification deleted successfully");
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
//        Notification notification = notificationService.getNotificationById(id);
//        return ResponseEntity.ok(notification);
//    }
//}