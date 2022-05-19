package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserRegistration {
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
    private LocalDate birthDate;
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String district;

    public UserRegistration(UserTxtDTO user, AddressTxtDTO address) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.role = user.getRole();
        this.genre = user.getGenre();
        this.birthDate = user.getBirthDate();
        this.state = address.getState();
        this.city = address.getCity();
        this.district = address.getDistrict();
    }
}
