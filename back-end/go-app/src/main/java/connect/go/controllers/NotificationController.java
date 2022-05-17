package connect.go.controllers;

import connect.go.models.Notification;
import connect.go.usecases.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getNotificationByUserId(@PathVariable Integer userId) {
        return ResponseEntity.of(notificationService.getNotificationByUserId(userId));
    }

    @PatchMapping("/view/{userId}")
    public ResponseEntity<Void> viewAllNotifications(@PathVariable Integer userId) {
        notificationService.viewAll(userId);
        return ResponseEntity.status(200).build();
    }
}
