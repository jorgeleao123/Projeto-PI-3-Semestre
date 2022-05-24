package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressTxtDTO {
    private String state;
    private String city;
    private String district;
}
