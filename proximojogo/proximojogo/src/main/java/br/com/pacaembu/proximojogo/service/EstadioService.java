package br.com.pacaembu.proximojogo.service;

import br.com.pacaembu.proximojogo.dto.EstadioDTO;
import br.com.pacaembu.proximojogo.dto.JogoDTO;
import br.com.pacaembu.proximojogo.model.Estadio;
import br.com.pacaembu.proximojogo.model.Jogo;
import br.com.pacaembu.proximojogo.repository.EstadioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstadioService {
    private final EstadioRepository estadioRepository;

    public EstadioDTO findById(Integer id) {
        Optional<Estadio> estadioOpt = estadioRepository.findById(id);
        if (estadioOpt.isPresent()) {
            return dtoDto(estadioOpt.get());
        }
    }

    private EstadioDTO dtoDto(Estadio estadio) {
        EstadioDTO estadioDTO = new EstadioDTO();
        estadioDTO.setId(estadio.getId());
        estadioDTO.setCapacidade(estadio.getCapacidade());

        estadioDTO.setJogos(toDtoJogo(estadio.getJogos()));

        return estadioDTO;
    }

    private static List<JogoDTO> toJogoDto(List<Jogo> jogos) {

    }
}
