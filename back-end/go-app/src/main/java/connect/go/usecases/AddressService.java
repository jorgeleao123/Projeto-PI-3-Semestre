package connect.go.usecases;

import connect.go.Repositories.AddressRepository;
import connect.go.models.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address register(Address address) {
        if (isAddressExists(address)){
            return findAllByDistrict(address.getDistrict()).orElseThrow(RuntimeException::new);
        }
        address.setCity(address.getCity().replace("ã","a"));
        return addressRepository.save(address);
    }

    private boolean isAddressExists(Address address) {
        return addressRepository.existsByDistrict(address.getDistrict());
    }

    public Optional<List<Address>> getFavoriteAddressByUserId(Integer id) {
        return addressRepository.getFavoriteAddressByUserId(id);
    }

    public Optional<Address> findAllByDistrict(String district) {
        return addressRepository.findAllByDistrict(district);
    }
}
