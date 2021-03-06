package connect.go.models;

import connect.go.models.dto.UserRegistration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @NotBlank
    private String name;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String role;
    @NotBlank
    private String genre;
    @NotBlank
    private String colorProfile;
    @NotBlank
    private String colorMenu;

    private LocalDate birthDate;

    private String status;

    private Integer searchCounter;

    public User(UserRegistration userRegistration) {
        this.name = userRegistration.getName();
        this.email = userRegistration.getEmail();
        this.password = userRegistration.getPassword();
        this.role = userRegistration.getRole();
        this.genre = userRegistration.getGenre();
        this.birthDate = userRegistration.getBirthDate();
        this.colorMenu = "#144D6C";
        this.colorProfile = "#1F869D";
        this.status = "ativo";
        this.searchCounter = 0;
    }
}