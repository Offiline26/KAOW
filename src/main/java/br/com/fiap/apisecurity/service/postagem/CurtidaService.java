package br.com.fiap.apisecurity.service.postagem;

import br.com.fiap.apisecurity.model.postagem.Curtida;
import br.com.fiap.apisecurity.model.postagem.Postagem;
import br.com.fiap.apisecurity.model.usuarios.Usuario;
import br.com.fiap.apisecurity.repository.postagem.CurtidaRepository;
import br.com.fiap.apisecurity.repository.postagem.PostagemRepository;
import br.com.fiap.apisecurity.repository.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public String curtirOuDescurtir(Integer idPostagem, Usuario usuario) {
        Postagem postagem = postagemRepository.findById(idPostagem)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));

        boolean jaCurtiu = curtidaRepository.existsByUsuarioAndPostagem(usuario, postagem);

        if (jaCurtiu) {
            // Descurtir
            Curtida curtida = curtidaRepository.findByUsuarioAndPostagem(usuario, postagem)
                    .orElseThrow(() -> new RuntimeException("Curtida não encontrada"));

            curtidaRepository.delete(curtida);

            // Atualizar total de curtidas
            if (usuario.getTotalCurtidas() == null) {
                usuario.setTotalCurtidas(0);  // Inicializa o valor caso seja nulo
            }

            // Atualizar total de curtidas
            usuario.setTotalCurtidas(usuario.getTotalCurtidas() - 1);
            usuarioRepository.save(usuario);

            usuario.setId(usuario.getId());

            return "Postagem descurtida com sucesso " + usuario.getId();
        } else {
            // Curtir
            Curtida novaCurtida = new Curtida();
            novaCurtida.setPostagem(postagem);
            novaCurtida.setUsuario(usuario);
            novaCurtida.setDataCurtida(LocalDateTime.now());

            curtidaRepository.save(novaCurtida);

            // Atualizar total de curtidas
            if (usuario.getTotalCurtidas() == null) {
                usuario.setTotalCurtidas(0);  // Inicializa o valor caso seja nulo
            }

            // Atualizar total de curtidas
            usuario.setTotalCurtidas(usuario.getTotalCurtidas() + 1);
            usuarioRepository.save(usuario);

            usuario.setId(usuario.getId());

            return "Postagem curtida com sucesso " + usuario.getId();
        }
    }
}