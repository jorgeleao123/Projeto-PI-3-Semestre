package connect.go.usecases;

import connect.go.Repositories.NotificationRepository;
import connect.go.models.Notification;
import connect.go.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final UserService userService;

    public void register(Integer userId, String title, String description) {
        User user = userService.getById(userId);
        Notification notification = new Notification(title, description, user);
        notificationRepository.save(notification);
    }

    public void viewAll(Integer userId) {
        notificationRepository.viewAllNotifications(userId);
    }

    public Optional<List<Notification>> getNotificationByUserId(Integer userId) {
        return notificationRepository.getByUserId(userId);
    }
}
