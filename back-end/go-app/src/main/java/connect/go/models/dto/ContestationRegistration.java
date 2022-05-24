package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class ContestationRegistration {

    private String description;

    private byte[] archive;

    private Integer userId;

    private Integer complaintId;

}
