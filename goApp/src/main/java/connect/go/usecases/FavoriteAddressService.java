package connect.go.usecases;

import connect.go.Repositories.FavoriteAddressRepository;
import connect.go.exceptions.AddressNotFoundException;
import connect.go.models.FavoriteAddress;
import connect.go.models.FavoriteAddressId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteAddressService {
    private final FavoriteAddressRepository favoriteAddressRepository;

    public void register(FavoriteAddressId favoriteAddressId) {
        FavoriteAddress favoriteAddress = new FavoriteAddress();
        favoriteAddress.setId(favoriteAddressId);
        favoriteAddressRepository.save(favoriteAddress);
    }

    public void deleteById(FavoriteAddressId favoriteAddressId) {
        if (existsById(favoriteAddressId)){
            favoriteAddressRepository.deleteById(favoriteAddressId);
        } else {
            throw new AddressNotFoundException();
        }
    }

    public boolean existsById(FavoriteAddressId favoriteAddressId) {
        return favoriteAddressRepository.existsById(favoriteAddressId);
    }
}
