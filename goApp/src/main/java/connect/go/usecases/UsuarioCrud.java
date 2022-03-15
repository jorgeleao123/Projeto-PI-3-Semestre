package connect.go.usecases;

import connect.go.models.Endereco;
import connect.go.models.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class UsuarioCrud implements ICrud {

    public  Map<String, Object> login(String usuario, String senha){
        String queryLogin = "SELECT *  FROM usuario where login_usuario = ? and senha_usuario = ?";
        Map<String, Object> registro = ASSISTENTE.queryForMap(queryLogin, usuario, senha);
        return registro;
    }

    @Override
    public Object create(Object o) {
        Usuario usuario = (Usuario) o;
        System.out.println("Cadastrando usuario");
        String queryUsuario = "INSERT INTO usuario(nome_usuario, login_usuario, senha_usuario, sexo_usuario, isAdmin," +
                " isMotorista, email_usuario) values (?,?,?,?,?,?,?)";
        ASSISTENTE.update(queryUsuario,usuario.getNomeUsuario(), usuario.getLoginUsuario(),
                usuario.pegarSenhaUsuario(), usuario.getSexoUsuario(), usuario.getIsAdmin(), usuario.getIsMotorista()
                , usuario.getEmailUsuario());
        Endereco endereco = usuario.getEndereco();
        Map<String, Object> usuarios = login(usuario.getLoginUsuario(), usuario.pegarSenhaUsuario());
        if (usuarios.isEmpty()){
            System.out.println("Erro ao cadastrar");
            return null;
        }
        List<Endereco> enderecos = new ArrayList<>();
        int idUsuario = (int) usuarios.get("id_usuario");
        try {
            //Verifica se já existe endereço cadastrado
            enderecos = ASSISTENTE.query("SELECT *  FROM endereco where cep =  ? ",
                    new BeanPropertyRowMapper<Endereco>(Endereco.class), endereco.getCep());
//            Endereco enderecoBanco = ASSISTENTE.queryForObject("SELECT *  FROM endereco where cep =  ? ",
//                new BeanPropertyRowMapper<Endereco>(Endereco.class), endereco.getCep());
            System.out.println("Cadastrando novo endereço");
            if (enderecos.isEmpty()){
            String queryEndereco = "INSERT INTO endereco(cep, estado, cidade, bairro) values (?,?,?,?)";
            ASSISTENTE.update(queryEndereco,endereco.getCep(), endereco.getEstado(), endereco.getCidade(), endereco.getBairro());
            enderecos = ASSISTENTE.query("SELECT *  FROM endereco where cep =  ? ",
                    new BeanPropertyRowMapper<Endereco>(Endereco.class), endereco.getCep());
            }
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar endereço");
        }
        try {
        System.out.println("Adicionando endereço favorito");
        String queryFavorito = "INSERT INTO endereco_favorito(fk_usuario, fk_endereco) values (?,?)";
        ASSISTENTE.update(queryFavorito,idUsuario, enderecos.get(0).getIdEndereco());
        usuario.setIdUsuario(idUsuario);

        } catch (Exception e) {
        System.out.println("Erro ao cadastrar endereço favorito");
    }
        return usuario;
    }

    @Override
    public Object getById(int id) {

        List<Usuario> list = ASSISTENTE.query("SELECT *  FROM usuario where id_usuario =  ? ",
                new BeanPropertyRowMapper(Usuario.class), id);
        return list.get(0);
    }

    @Override
    public List<Object> get() {

        return ASSISTENTE.query("SELECT * FROM usuario", new BeanPropertyRowMapper(Usuario.class));
    }

    @Override
    public Object updateById(int id, Object o) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
