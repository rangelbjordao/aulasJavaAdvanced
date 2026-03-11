package br.com.pacaembu.proximojogo.repository;

import br.com.pacaembu.proximojogo.model.Comentario;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository {

    Comentario save(Comentario comentario);
}
