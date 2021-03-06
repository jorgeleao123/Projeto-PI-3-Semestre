package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class ComplaintRegistration {

    private String type;

    private String description;

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

    private LocalDate dateTimeComplaint;

}
