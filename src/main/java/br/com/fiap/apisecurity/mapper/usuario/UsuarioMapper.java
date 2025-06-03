package br.com.fiap.apisecurity.mapper.usuario;

import br.com.fiap.apisecurity.dto.usuario.UsuarioDTO;
import br.com.fiap.apisecurity.model.usuarios.TipoUsuario;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioDTO dto, TipoUsuario tipoUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setNomeUsuario(dto.getNomeUsuario());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());
        usuario.setTipoUsuario(tipoUsuario);
        return usuario;
    }

    public UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setNome(usuario.getNome());
        dto.setNomeUsuario(usuario.getNomeUsuario());
        dto.setEmail(usuario.getEmail());
        dto.setIdTipoUsuario(usuario.getTipoUsuario().getId());
        return dto;
    }
}



