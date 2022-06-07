package connect.go.Repositories;

import connect.go.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Notification n set n.hasViewed=true where n.user.id=?1 and n.hasViewed=false")
    void viewAllNotifications(Integer userId);

    @Query("select n from Notification n where n.user.id = ?1 order by n.dateTimeNotification desc")
    Optional<List<Notification>> getByUserId(Integer userId);
}
