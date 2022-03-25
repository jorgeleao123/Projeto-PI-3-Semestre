package connect.go.Repositories;

import connect.go.models.FavoriteAddress;
import connect.go.models.FavoriteAddressId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteAddressRepository extends JpaRepository<FavoriteAddress, FavoriteAddressId> {
}
