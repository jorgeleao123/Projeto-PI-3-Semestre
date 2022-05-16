package connect.go.usecases;

import connect.go.Repositories.FavoriteAddressRepository;
import connect.go.exceptions.BadRequestException;
import connect.go.exceptions.FavoriteAddressAlreadyExistsException;
import connect.go.exceptions.FavoriteAddressNotFoundException;
import connect.go.models.Address;
import connect.go.models.FavoriteAddressId;
import connect.go.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class FavoriteAddressServiceTest {


    @Autowired
    private FavoriteAddressService service;

    @Autowired
    private AddressService addressService;

    @Autowired
    private UserService userService;

    @Autowired
    private FavoriteAddressRepository repository;

    User user = new User();
    Address address = new Address();
    Address address2 = new Address();

    @BeforeEach
    void setUp() {
        user.setName("Mauricio");
        user.setEmail("mauricio@teste.com");
        user.setPassword("senhaTeste");
        user.setRole("Usuario");
        user.setGenre("Masculino");
        user = userService.register(user);
        address.setCity("São Paulo");
        address.setDistrict("Vila Carrrão");
        address.setState("SP");
        address2.setCity("São Paulo");
        address2.setState("SP");
        address2.setDistrict("Cidade São Francisco");
    }
    @Test
    void successRegisterTest() {
        address = addressService.register(address);
        address2 = addressService.register(address2);

        service.register(new FavoriteAddressId(user.getId(), address.getId()));
        assertEquals(1, repository.findAll().size());
        service.register(new FavoriteAddressId(user.getId(), address2.getId()));
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void duplicateRegisterTest() {
        address = addressService.register(address);

        service.register(new FavoriteAddressId(user.getId(), address.getId()));
        assertEquals(1, repository.findAll().size());
        assertThrows(FavoriteAddressAlreadyExistsException.class, () -> service.register(new FavoriteAddressId(user.getId(), address.getId())));
        assertEquals(1, repository.findAll().size());
    }

    @Test
    void successDeleteTest() {
        address = addressService.register(address);
        address2 = addressService.register(address2);

        service.register(new FavoriteAddressId(user.getId(), address.getId()));
        service.register(new FavoriteAddressId(user.getId(), address2.getId()));
        assertEquals(2, repository.findAll().size());
        service.deleteById(new FavoriteAddressId(user.getId(), address.getId()));
        service.deleteById(new FavoriteAddressId(user.getId(), address2.getId()));
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void failDeleteTest() {
        address = addressService.register(address);

        service.register(new FavoriteAddressId(user.getId(), address.getId()));
        assertEquals(1, repository.findAll().size());
        assertThrows(FavoriteAddressNotFoundException.class, () -> service.deleteById(new FavoriteAddressId(user.getId(), address2.getId())));
        assertEquals(1, repository.findAll().size());
    }
}