package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserTxtDTO {
    private String name;
    private String email;
    private String password;
    private String role;
    private String genre;
    private LocalDate birthDate;
}
