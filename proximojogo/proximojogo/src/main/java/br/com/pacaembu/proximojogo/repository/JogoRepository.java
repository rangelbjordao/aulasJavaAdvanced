package br.com.pacaembu.proximojogo.repository;

import br.com.pacaembu.proximojogo.model.Estadio;
import br.com.pacaembu.proximojogo.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByEstadio(Estadio estadio);
}
