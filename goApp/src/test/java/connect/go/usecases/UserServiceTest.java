package connect.go.usecases;

import connect.go.Repositories.UserRepository;
import connect.go.exceptions.UserAlreadyExistsException;
import connect.go.exceptions.UserNotFoundException;
import connect.go.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @BeforeEach
    void setUp() {
        service = new UserService(repository);
    }

    @Test
    void successRegisterTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        assertEquals(user, repository.findAll().get(0));

    }

    @Test
    void registerDuplicatedEmailTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        assertEquals(user, repository.findAll().get(0));
        assertThrows(UserAlreadyExistsException.class, () -> service.register(generateValidUser()));

    }

    @Test
    void successLoginTest() {
        User user = service.register(generateValidUser());
        List<User> users = service.login("mauricio@teste.com","senhaTeste");
        assertEquals(user.getName(), users.get(0).getName());
        assertEquals(user.getEmail(), users.get(0).getEmail());
        assertEquals(user.getRole(), users.get(0).getRole());

    }
    @Test
    void failLoginTest() {
        List<User> users = service.login("mauricio@teste.com","senhaTeste");
        assertEquals(0, users.size());

    }

    @Test
    void successDeleteTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        assertEquals(user, repository.findAll().get(0));
        assertEquals(user, service.getById(user.getId()));
        service.deleteById(user.getId());
        assertThrows(UserNotFoundException.class, () -> service.getById(user.getId()));

    }

    @Test
    void failDeleteTest() {
        assertThrows(UserNotFoundException.class, () -> service.getById(1));

    }

    @Test
    void successUpdateEmailByIdTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        assertTrue(service.updateEmailById(user.getId(), "mauricio2@teste.com"));
        User updatedUser = service.getById(user.getId());
        assertEquals(user.getId(), updatedUser.getId());
        assertNotEquals(user.getEmail(), updatedUser.getEmail());
        assertEquals("mauricio2@teste.com", updatedUser.getEmail());

    }

    @Test
    void successUpdatePasswordByIdTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        assertTrue(service.updatePasswoordById(user.getId(), user.getPassword(), "senhaTeste2"));
        User updatedUser = service.getById(user.getId());
        assertEquals(user.getId(), updatedUser.getId());
        assertNotEquals(user.getPassword(), updatedUser.getPassword());
        assertEquals("senhaTeste2", updatedUser.getPassword());

    }

    @Test
    void failUpdatePasswordByIdTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        assertFalse(service.updatePasswoordById(user.getId(), "senhaErrada", "senhaTeste2"));
        User updatedUser = service.getById(user.getId());
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals(user.getPassword(), updatedUser.getPassword());
        assertNotEquals("senhaTeste2", updatedUser.getPassword());

    }

    @Test
    void successUpdateByIdTest() {
        User user = service.register(generateValidUser());
        assertNotNull(user);
        User newUser = new User(user.getId(),"Tais", "tais@teste.com", user.getPassword(), "admin","Faminino");
        assertTrue(service.updateById(user.getId(), newUser));
        User updatedUser = service.getById(user.getId());
        assertEquals(user.getId(), updatedUser.getId());
        assertNotEquals(user, updatedUser);
        assertEquals(newUser, updatedUser);

    }


    private User generateValidUser() {
        User user = new User();
        user.setName("Mauricio");
        user.setEmail("mauricio@teste.com");
        user.setPassword("senhaTeste");
        user.setRole("Usuario");
        user.setSex("Masculino");
        return user;
    }
}