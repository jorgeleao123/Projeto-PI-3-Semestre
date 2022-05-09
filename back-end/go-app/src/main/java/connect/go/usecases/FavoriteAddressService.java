package connect.go.usecases;

import connect.go.Repositories.FavoriteAddressRepository;
import connect.go.exceptions.FavoriteAddressAlreadyExistsException;
import connect.go.exceptions.FavoriteAddressNotFoundException;
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
        if (existsById(favoriteAddressId)){
            throw new FavoriteAddressAlreadyExistsException();
        }else {
            favoriteAddressRepository.save(favoriteAddress);
        }
    }

    public void deleteById(FavoriteAddressId favoriteAddressId) {
        if (existsById(favoriteAddressId)){
            favoriteAddressRepository.deleteById(favoriteAddressId);
        } else {
            throw new FavoriteAddressNotFoundException();
        }
    }

    public boolean existsById(FavoriteAddressId favoriteAddressId) {
        return favoriteAddressRepository.existsByUserIdAndAddressId(favoriteAddressId.getUserId(), favoriteAddressId.getAddressId());
    }
}
