package connect.go.usecases;

import connect.go.models.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public class UsuarioCrud implements ICrud {

    public boolean login(String usuario, String senha){
        List<Usuario> lista = ASSISTENTE.query("query", new BeanPropertyRowMapper<>(Usuario.class));
        if (lista.size() == 1) {
            return true;
        }
        return false;
    }

    @Override
    public Object create(Object o) {
        //Cria usuario
        //Verifica se ja tem endereço cadastrado
        //caso nao tenha cria um endereço
        //Cria associaao entre usuario e o endereço
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public List<Object> get() {
        return null;
    }

    @Override
    public Object updateById(int id, Object o) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
