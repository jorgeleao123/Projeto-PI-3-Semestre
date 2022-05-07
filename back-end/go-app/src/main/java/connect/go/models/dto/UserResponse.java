package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {

    private Integer id;

    private String name;

    private String email;

    private String role;

    private String genre;

}
