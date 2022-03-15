package connect.go.models;



public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private int isAdmin;
    private int isMotorista;
    private String sexoUsuario;
//    private Endereco endereco;

    public Usuario(int idUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, String sexoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.isAdmin = 0;
        this.isMotorista = 0;
        this.sexoUsuario = sexoUsuario;
    }

    public String getSexoUsuario() {
        return sexoUsuario;
    }

    public void setSexoUsuario(String sexoUsuario) {
        this.sexoUsuario = sexoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    // escondendo a senha
     public String pegarSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
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

//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
}