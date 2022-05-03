package connect.go.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;

@Data
@AllArgsConstructor
public class UserRegistration {
    @Valid
    private User user;
    @Valid
    private Address address;

}
