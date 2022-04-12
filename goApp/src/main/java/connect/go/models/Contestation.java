package connect.go.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Contestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contestarion")
    private Integer id;

    private String description;

    private String title;

    private String archive;

    private String status;

    @Column(name = "dt_contestarion")
    private LocalDateTime dateTimeContestation;

    @JoinColumn(name = "id_user")
    @ManyToOne
    private User user;

    @JoinColumn(name = "id_complaint")
    @ManyToOne
    private Complaint complaint;
}
