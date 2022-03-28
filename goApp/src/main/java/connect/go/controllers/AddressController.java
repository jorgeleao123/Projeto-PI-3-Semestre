package connect.go.controllers;

import connect.go.models.Address;
import connect.go.models.FavoriteAddress;
import connect.go.models.FavoriteAddressId;
import connect.go.usecases.AddressService;
import connect.go.usecases.FavoriteAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    private final FavoriteAddressService favoriteAddressService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<Object> getAddressByUserId(@PathVariable Integer userId) {
        List<Address> addressList = addressService.getFavoriteAddressByUserId(userId);
        return ResponseEntity.status(200).body(addressList);
    }

    @PostMapping()
    public ResponseEntity<Object> createAddress(@RequestBody Address address) {
        Address newAddress = addressService.register(address);
        return ResponseEntity.status(201).body(newAddress);
    }

    @PostMapping("/users/{userId}")
    public ResponseEntity<Object> createAddress(@RequestBody Address address, @PathVariable Integer userId) {
        Address newAddress = addressService.register(address);
        favoriteAddressService.register(new FavoriteAddressId(userId,
                newAddress.getId()));
        return ResponseEntity.status(201).body(newAddress);
    }

    @DeleteMapping("/users/{userId}/{addressId}")
    public ResponseEntity<Object> deleteFavoriteAddress(@PathVariable Integer userId, @PathVariable Integer addressId) {
        favoriteAddressService.deleteById(new FavoriteAddressId(userId, addressId));
        return ResponseEntity.status(201).build();
    }
}
