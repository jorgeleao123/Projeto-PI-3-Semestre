package connect.go.controllers;

import connect.go.exceptions.BadRequestException;
import connect.go.exceptions.UserNotFoundException;
import connect.go.models.Endereco;
import connect.go.models.EnderecoFavoritoId;
import connect.go.models.Usuario;
import connect.go.models.UsuarioCadastro;
import connect.go.models.UsuarioResponse;
import connect.go.usecases.EnderecoFavoritoService;
import connect.go.usecases.EnderecoService;
import connect.go.usecases.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final EnderecoService enderecoService;

    private final EnderecoFavoritoService enderecoFavoritoService;

    @PostMapping
    public ResponseEntity<Object> createUsuario(@RequestBody UsuarioCadastro usuarioCadastro) {
        log.info("usuario {}", usuarioCadastro.getUsuario().getNome());
        log.info("Endereco {}", usuarioCadastro.getEndereco().getCep());
        Usuario usuario = usuarioService.cadastrar(usuarioCadastro.getUsuario());
        Endereco enderecoCadastro = usuarioCadastro.getEndereco();
        Endereco endereco = enderecoService.cadastrar(enderecoCadastro);
        EnderecoFavoritoId enderecoFavoritoId = new EnderecoFavoritoId();
        enderecoFavoritoId.setEnderecoId(endereco.getId());
        enderecoFavoritoId.setUsuarioId(usuario.getId());
        enderecoFavoritoService.cadastrar(enderecoFavoritoId);
        return ResponseEntity.status(201).body(this.convertUsuarioToUsuarioResponde(usuario));
    }

    @PostMapping("/login/{login}/{senha}")
    public ResponseEntity<Object> loginUsuario(@PathVariable String login, @PathVariable String senha) {
        List<Usuario> usuarios = usuarioService.login(login, senha);
        if (usuarios.size() != 1) {
            throw new BadRequestException();
        }
        return ResponseEntity.status(200).body(this.convertUsuarioToUsuarioResponde(usuarios.get(0)));
    }

    @GetMapping
    public ResponseEntity<Object> getUsuarios() {
        List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioResponse> responseUsuarios = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            responseUsuarios.add(convertUsuarioToUsuarioResponde(usuario));
        }
        return ResponseEntity.status(200).body(responseUsuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.getById(id);
        return ResponseEntity.status(200).body(convertUsuarioToUsuarioResponde(usuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuarioById(@PathVariable int id, @RequestBody Usuario usuario) {
        usuarioService.updateById(id, usuario);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarioById(@PathVariable Integer id) {
        try {
            usuarioService.deleteById(id);
            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            throw new UserNotFoundException();
        }
    }

    private UsuarioResponse convertUsuarioToUsuarioResponde(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),usuario.getNome(),usuario.getLogin(),usuario.getIsAdmin(),usuario.getIsMotorista(),
                usuario.getSexo(),usuario.getEmail()
        );
        return usuarioResponse;
    }
}
