package connect.go.controllers;

import connect.go.models.Usuario;
import connect.go.usecases.UsuarioCrud;
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
import java.util.Map;

@RestController
@RequestMapping("/usuarios2")
public class Usuario2Controller {

    private final UsuarioCrud usuarioCrud = new UsuarioCrud();

    @PostMapping
    public ResponseEntity<Object> createUsuario(@RequestBody Usuario usuario) {
        usuarioCrud.create(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @PostMapping("/login/{usuario}/{senha}")
    public ResponseEntity<Object> loginUsuario(@PathVariable String usuario, @PathVariable String senha) {
        Map<String, Object> usuarios = usuarioCrud.login(usuario, senha);
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping
    public ResponseEntity<Object> getUsuarios() {
        List<Object> objetos = usuarioCrud.get();
        List<Usuario> usuarios = new ArrayList<>();
        for (Object object: objetos) {
            usuarios.add((Usuario)object);
        }
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getUsuarioById(@PathVariable int id) {
        Usuario usuario = (Usuario) usuarioCrud.getById(id);
        return ResponseEntity.status(200).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsuarioById(@PathVariable int id, @RequestBody Usuario usuario) {
        usuarioCrud.updateById(id, usuario);
        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUsuarioById(@PathVariable int id) {
        usuarioCrud.deleteById(id);
        return ResponseEntity.status(200).build();
    }
}
