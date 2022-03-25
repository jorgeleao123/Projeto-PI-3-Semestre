package connect.go.Repositories;

import connect.go.models.Usuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    @DisplayName("Teste de cadastro de usuário")
    void cadastrarUsuarioValido() {
        Usuario usuarioSalvo = usuarioRepository.save(getUsuario());

        assertNotNull(usuarioSalvo);
        assertNotNull(usuarioSalvo.getId());
        assertEquals(getUsuario().getNome(), usuarioSalvo.getNome());
    }



    private Usuario getUsuario() {
        return new Usuario("joao", "joaozinho", "joao123");
    }
}