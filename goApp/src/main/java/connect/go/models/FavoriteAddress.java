package connect.go.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteAddress {

    @EmbeddedId
    private FavoriteAddressId id;

    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User user;

    @JoinColumn(name = "id_address", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Address address;

}
