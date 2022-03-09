package api.go.controller;

import api.go.entidades.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
/// define o caminho http://localhost:8080/usuario
@RequestMapping("/usuario")
public class UsuariosController {
    private List<Usuario> usuarios = new ArrayList<>();


    /// Cadastrando usuario
    /// define o caminho post http://localhost:8080/usuario
    @PostMapping
    public String postUsuario(@RequestBody Usuario usuarionovo) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLoginUsuario().equals(usuarionovo.getLoginUsuario())) {
                return "Usuario já existe";
            }

        }
        usuarios.add(usuarionovo);
        return "Usuario Cadastrado";
    }

    /// retornando todos usuario
    /// define o caminho http://localhost:8080/usuario
    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /// Pesquisando usuario
    /// define o caminho get http://localhost:8080/usuario/{id}
    @GetMapping("/{id}")
    public List<Usuario> getUsers(@PathVariable int id) {
        /// criando uma "sublista"
        List<Usuario> listarItens = new ArrayList<>();
        for (Usuario usuario : usuarios)
            if (usuario.getIdUsuario() == id) {
                listarItens.add(usuario);
            }
        return listarItens;
    }

    /// fazendo login
    /// define o caminho  post http://localhost:8080/usuario/autenticar
    @PostMapping("/autenticar/{loginUsuario}/{senhaUsuario}")
    public String loginUsers(@PathVariable String loginUsuario, @PathVariable String senhaUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLoginUsuario().equals(loginUsuario)
                    && usuario.getSenhaUsuario().equals(senhaUsuario)) {
                usuario.setAutenticado(true);
                return "Logado";
            }
        }
        return "Dados Incorretos";
    }

    /// fazendo logoff
    /// define o caminho  post http://localhost:8080/usuario/autenticar
    @DeleteMapping("/autenticar/{loginUsuario}")
    public String logoffUsuario(@PathVariable String loginUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLoginUsuario().equals(loginUsuario)) {
                if (usuario.getAutenticado()) {
                    usuario.setAutenticado(false);
                }
                return "Usuario não esta logado";
            }
        }
        return "Usuario não encontrado";
    }

}
