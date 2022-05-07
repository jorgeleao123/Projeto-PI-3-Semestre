package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ComplaintRegistration {

    private String type;

    private String description;

    private String archive;

    private String status;

    private String bo;

    private String driverName;
    @NotBlank
    private String licensePlate;
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String district;
}
