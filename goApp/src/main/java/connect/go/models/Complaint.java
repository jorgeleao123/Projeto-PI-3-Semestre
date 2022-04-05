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
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_complaint")
    private Integer id;

    private String description;

    private String title;

    private String archive;

    private String status;

    private String bo;

    @Column(name = "dt_complaint")
    private LocalDateTime dateTimeComplaint;

    private String type;

    @JoinColumn(name = "id_driver")
    @ManyToOne
    private Driver driver;

    @JoinColumn(name = "id_user")
    @ManyToOne
    private User user;

    @JoinColumn(name = "id_address")
    @ManyToOne
    private Address address;


//    @OneToMany(mappedBy = "contestation")
//    private List<Contestation> contestations;
}
