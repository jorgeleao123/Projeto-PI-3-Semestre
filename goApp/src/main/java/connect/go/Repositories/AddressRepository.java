package connect.go.Repositories;

import connect.go.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    boolean existsByCep(String cep);

    List<Address> findAllByCep(String cep);

}
