package connect.go.usecases;

import connect.go.Repositories.FavoriteAddressRepository;
import connect.go.models.FavoriteAddress;
import connect.go.models.FavoriteAddressId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoriteAddressService {
    private final FavoriteAddressRepository favoriteAddressRepository;

    public FavoriteAddress register(FavoriteAddressId favoriteAddressId) {
        FavoriteAddress favoriteAddress = new FavoriteAddress();
        favoriteAddress.setId(favoriteAddressId);
        return favoriteAddressRepository.save(favoriteAddress);
    }
}
