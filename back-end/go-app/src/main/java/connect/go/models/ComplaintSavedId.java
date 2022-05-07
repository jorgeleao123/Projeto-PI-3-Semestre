package connect.go.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ComplaintSavedId implements Serializable {

    @Column(name = "id_user")
    private Integer userId;

    @Column(name = "id_complaint")
    private Integer complaintId;

}
