package br.com.fiap.apisecurity.dto.usuario;

public class LoginResponse {

    private String token;
    private Integer idUsuario;
    private Integer idTipoUsuario;

    public LoginResponse(String token, Integer idUsuario, Integer idTipoUsuario) {
        this.token = token;
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getToken() {
        return token;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }
}
