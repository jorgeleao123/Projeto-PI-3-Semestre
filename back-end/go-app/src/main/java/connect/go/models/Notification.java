package connect.go.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private Integer id;

    private String description;

    private String title;

    private Boolean hasViewed;

    @Column(name = "dt_notification")
    private LocalDateTime dateTimeNotification;

    @JoinColumn(name = "id_user")
    @ManyToOne
    private User user;

    public Notification(String title, String description, User user) {
        this.description = description;
        this.title = title;
        this.user = user;
        this.hasViewed = false;
        this.dateTimeNotification = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
