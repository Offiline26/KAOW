package br.com.fiap.apisecurity.dto.usuario;

public class LoginResponse {

    private String token;
    private Long idUsuario;
    private Long idTipoUsuario;

    public LoginResponse(String token, Long idUsuario, Long idTipoUsuario) {
        this.token = token;
        this.idUsuario = idUsuario;
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getToken() {
        return token;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public Long getIdTipoUsuario() {
        return idTipoUsuario;
    }
}
