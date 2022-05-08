package connect.go.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

}
