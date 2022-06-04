package connect.go.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ComplaintSavedRegistration {

    private Integer userId;
    private Integer complaintId;
}
