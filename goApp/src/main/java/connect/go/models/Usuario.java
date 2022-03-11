package connect.go.models;

public class Usuario {
    private int idUsuario;
    private String nomeUsuario;
    private String loginUsuario;
    private String senhaUsuario;
    private Boolean isAdmin;
    private Boolean isMotorista;
    private Boolean isAutenticado;

    public Usuario(int idUsuario, String nomeUsuario, String loginUsuario, String senhaUsuario, Boolean isAdmin, Boolean isMotorista) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.loginUsuario = loginUsuario;
        this.senhaUsuario = senhaUsuario;
        this.isAdmin = isAdmin;
        this.isMotorista = isMotorista;
        this.isAutenticado = false;
    }

    public Boolean getAutenticado() {
        return isAutenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        isAutenticado = autenticado;
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

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getMotorista() {
        return isMotorista;
    }

    public void setMotorista(Boolean motorista) {
        isMotorista = motorista;
    }
}