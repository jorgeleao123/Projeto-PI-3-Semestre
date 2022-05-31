package connect.go.Repositories;

import connect.go.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    boolean existsByDistrict(String district);

    Optional<Address> findAllByDistrict(String district);

    @Query("select a from FavoriteAddress f join f.address a where f.user.id = ?1")
    Optional<List<Address>> getFavoriteAddressByUserId(Integer userId);

}
