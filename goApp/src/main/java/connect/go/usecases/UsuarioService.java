package connect.go.usecases;

import connect.go.Repositories.UsuarioRepository;
import connect.go.exceptions.UserNotFoundException;
import connect.go.models.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public Usuario cadastrar(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    public List<Usuario> login(String login, String senha) {
        return this.usuarioRepository.findByLoginAndSenha(login, senha);
    }

    public void deleteById(Integer id) throws UserNotFoundException {
        if (this.usuarioRepository.existsById(id)) {
            this.usuarioRepository.deleteById(id);
        } else {
            throw new UserNotFoundException();
        }
    }

    public Usuario getById(Integer id) {
        return this.usuarioRepository
                .findById(id)
                .orElseThrow();
    }

    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    public Usuario updateById(Integer id, Usuario usuario) throws UserNotFoundException {
        deleteById(id);
        usuario.setId(id);
        return this.cadastrar(usuario);
    }
}
