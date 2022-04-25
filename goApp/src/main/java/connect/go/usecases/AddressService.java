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
            return findAllByCep(address.getCep()).get().get(0);
        }
        return addressRepository.save(address);
    }

    private boolean isAddressExists(Address address) {
        return addressRepository.existsByCep(address.getCep());
    }

    public Optional<List<Address>> getFavoriteAddressByUserId(Integer id) {
        return addressRepository.getFavoriteAddressByUserId(id);
    }

    public Optional<List<Address>> findAllByCep(String cep) {
        return addressRepository.findAllByCep(cep);
    }
}
