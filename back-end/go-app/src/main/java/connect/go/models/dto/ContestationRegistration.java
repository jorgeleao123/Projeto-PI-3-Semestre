package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class ContestationRegistration {

    private String description;

    private String archive;

    private Integer userId;

    private Integer complaintId;

}
