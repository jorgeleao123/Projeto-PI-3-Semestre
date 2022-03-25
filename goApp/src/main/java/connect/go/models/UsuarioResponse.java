package connect.go.models;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UsuarioResponse {

    private Integer id;

    private String nome;

    private String login;

    private int isAdmin;

    private int isMotorista;

    private String sexo;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsMotorista() {
        return isMotorista;
    }

    public void setIsMotorista(int isMotorista) {
        this.isMotorista = isMotorista;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
