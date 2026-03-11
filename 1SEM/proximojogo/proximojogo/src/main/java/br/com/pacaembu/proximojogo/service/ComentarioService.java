package br.com.pacaembu.proximojogo.service;

import br.com.pacaembu.proximojogo.dto.ComentarioDTO;
import br.com.pacaembu.proximojogo.model.Comentario;
import br.com.pacaembu.proximojogo.repository.ComentarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ComentarioService {

    private ComentarioRepository comentarioRepository;

    public ComentarioDTO salvarComentario(ComentarioDTO comentarioDTO) {
        Comentario comentario = toEntity(comentarioDTO);
        Comentario comentarioSalvo = comentarioRepository.save(comentario);
        return toDTO(comentarioSalvo);
    }

    private ComentarioDTO toDTO(Comentario comentarioSalvo) {
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setMensagem(comentarioSalvo.getMensagem());
        comentarioDTO.setUuid(comentarioSalvo.getUuid());
        return comentarioDTO;
    }

    private Comentario toEntity(ComentarioDTO comentarioDTO) {
        Comentario comentario = new Comentario();
        comentario.setMensagem(comentarioDTO.getMensagem());
        return comentario;
    }
}