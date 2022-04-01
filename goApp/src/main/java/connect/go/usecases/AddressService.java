package connect.go.usecases;

import connect.go.Repositories.AddressRepository;
import connect.go.models.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    public Address register(Address address) {
        if (isAddressExists(address)){
            return addressRepository.findAllByCep(address.getCep()).get(0);
        }
        return addressRepository.save(address);
    }

    private boolean isAddressExists(Address address) {
        return addressRepository.existsByCep(address.getCep());
    }

    public List<Address> getFavoriteAddressByUserId(Integer id) {
        return addressRepository.getFavoriteAddressByUserId(id);
    };
}
