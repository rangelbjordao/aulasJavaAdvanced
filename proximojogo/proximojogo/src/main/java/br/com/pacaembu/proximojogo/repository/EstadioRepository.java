package br.com.pacaembu.proximojogo.repository;

import br.com.pacaembu.proximojogo.model.Estadio;

import java.util.Optional;

public interface EstadioRepository {
    Optional<Estadio> findById(Integer id);
}
