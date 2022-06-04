package connect.go.usecases;

import connect.go.Repositories.DriverRepository;
import connect.go.models.Driver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {
    private final DriverRepository driverRepository;

    public Driver register(Driver driver) {
        List<Driver> drivers = findDriverByNameAndLicensePlate(driver.getName(), driver.getLicensePlate());
        if (drivers.isEmpty()) {
            return driverRepository.save(driver);
        }
        return drivers.get(0);
    }

    public List<Driver> findDriverByNameAndLicensePlate(String name, String license) {
        return driverRepository.findDriverByNameAndLicensePlate(name, license);
    }

}
