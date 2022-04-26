package connect.go.Repositories;

import connect.go.models.FavoriteAddress;
import connect.go.models.FavoriteAddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteAddressRepository extends JpaRepository<FavoriteAddress, FavoriteAddressId> {

    boolean existsByUserIdAndAddressId(Integer userId, Integer AddressId);
}
