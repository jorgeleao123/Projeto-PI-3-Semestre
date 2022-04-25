package connect.go.Repositories;

import connect.go.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

    List<Driver> findDriverByNameAndLicense(String name, String license);


}
