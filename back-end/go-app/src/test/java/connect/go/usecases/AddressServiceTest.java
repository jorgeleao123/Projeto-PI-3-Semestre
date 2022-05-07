package connect.go.usecases;

import connect.go.Repositories.AddressRepository;
import connect.go.models.Address;
import connect.go.models.FavoriteAddressId;
import connect.go.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class AddressServiceTest {

    @Autowired
    private AddressService service;

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteAddressService favoriteAddressService;

    @Autowired
    private AddressRepository repository;

    @Test
    void successRegisterTest() {
        Address address = service.register(generateValidAdderss());
        assertNotNull(address);
        assertNotNull(address.getId());
        assertEquals(address, repository.findAll().get(0));

    }

    @Test
    void registerDuplicatedCepTest() {
        Address address = service.register(generateValidAdderss());
        assertNotNull(address);
        assertNotNull(address.getId());
        assertEquals(address, repository.findAll().get(0));

        Address address2 = service.register(generateValidAdderss());

        assertEquals(1, repository.findAll().size(), "Não cadastrou o endereço de novo");
        assertEquals(address,address2, "Retorna o endereço com o mesmo cep");

    }

    @Test
    void successFindAllByDistrictTest() {
        Address address = service.register(generateValidAdderss());
        service.register(generateValidAdderss());
        Address address2 = service.findAllByDistrict(address.getDistrict()).get();
        assertEquals(address, address2);

    }

    @Test
    void failFindAllByCepTest() {
        Optional<Address> addressOptional = service.findAllByDistrict("00000000");
        assertFalse(addressOptional.isPresent());
    }

    @Test
    void getFavoriteAddressTest() {
        User user = new User();
        user.setName("Mauricio");
        user.setEmail("mauricio@teste.com");
        user.setPassword("senhaTeste");
        user.setRole("Usuario");
        user.setGenre("Masculino");
        user = userService.register(user);
        Address address = service.register(generateValidAdderss());
        Address address2 = generateValidAdderss();
        address2.setDistrict("Cidade São Francisco");
        address2 = service.register(address2);
        favoriteAddressService.register(new FavoriteAddressId(user.getId(), address.getId()));
        favoriteAddressService.register(new FavoriteAddressId(user.getId(), address2.getId()));
        Optional<List<Address>> listOptional = service.getFavoriteAddressByUserId(user.getId());
        List<Address> addressList = listOptional.orElse(Collections.EMPTY_LIST);
        assertFalse(addressList.isEmpty());
        assertEquals(2, addressList.size());
        assertTrue(addressList.contains(address));
        assertTrue(addressList.contains(address2));
    }

    private Address generateValidAdderss() {
        Address address = new Address();
        address.setCity("São Paulo");
        address.setDistrict("Vila Carrrão");
        address.setState("SP");
        return address;
    }
}