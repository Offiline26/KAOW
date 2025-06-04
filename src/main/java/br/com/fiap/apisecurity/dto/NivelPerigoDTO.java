package br.com.fiap.apisecurity.dto;

public class NivelPerigoDTO {
    private Long id;
    private String nivelPerigo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNivelPerigo() {
        return nivelPerigo;
    }

    public void setNivelPerigo(String nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }
}
