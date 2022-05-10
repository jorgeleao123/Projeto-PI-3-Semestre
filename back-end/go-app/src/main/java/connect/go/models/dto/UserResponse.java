package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserResponse {

    private Integer id;

    private String name;

    private String email;

    private String role;

    private String genre;

    private String colorProfile;

    private String colorMenu;

    private LocalDate birthDate;

    private String status;

}
