package connect.go.Repositories;

import connect.go.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Teste de cadastro de usuário")
    void cadastrarUsuarioValido() {
        User userSave = userRepository.save(getUser());

        assertNotNull(userSave);
        assertNotNull(userSave.getId());
        assertEquals(getUser().getName(), userSave.getName());
    }



    private User getUser() {
        User user = new User();
        user.setName("João");
        user.setEmail("joao@teste.com");
        user.setPassword("joao123");
        user.setRole("Passenger");
        user.setSex("Male");
        return user;
    }
}