package br.com.pacaembu.proximojogo.repository;

import br.com.pacaembu.proximojogo.model.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {
    Optional<Estadio> findById(Long id);
}
