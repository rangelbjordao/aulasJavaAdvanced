package br.com.pacaembu.proximojogo.service;

import br.com.pacaembu.proximojogo.dto.EstadioDTO;
import br.com.pacaembu.proximojogo.model.Estadio;
import br.com.pacaembu.proximojogo.model.Jogo;
import br.com.pacaembu.proximojogo.dto.JogoDTO;
import br.com.pacaembu.proximojogo.repository.EstadioRepository;
import br.com.pacaembu.proximojogo.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static br.com.pacaembu.proximojogo.service.Mappings.toJogoDTO;
import static br.com.pacaembu.proximojogo.service.Mappings.toJogoEntity;

@Service
@AllArgsConstructor
public class JogoService {

    private JogoRepository jogoRepository;
    private EstadioRepository estadioRepository;


    public JogoDTO proximoJogoPorEstadio(Long idEstadio) {
        Estadio estadio = getEstadio(idEstadio);

        List<Jogo> lista = jogoRepository.findByEstadio(estadio);
        if (lista.isEmpty()) {
            return new JogoDTO();
        }
        Jogo proximoJogo = lista.get(lista.size() - 1);
        return toJogoDTO(proximoJogo);
    }

    public JogoDTO salvarProximoJogo(JogoDTO jogoDTO) throws IllegalArgumentException {
        Jogo jogoEntity = toJogoEntity(jogoDTO);
        EstadioDTO estadioDTO = jogoDTO.getEstadioDTO();

        Estadio estadio = getEstadio(estadioDTO.getId());
        jogoEntity.setEstadio(estadio);
        Jogo jogoSalvo = jogoRepository.save(jogoEntity);
        return toJogoDTO(jogoSalvo);
    }

    private Estadio getEstadio(Long idEstadio) {
        Optional<Estadio> estadioOptional = estadioRepository
                .findById(idEstadio);
        if (estadioOptional.isEmpty()) {
            throw new IllegalArgumentException("Estadio not found");
        }
        return estadioOptional.get();
    }

    public JogoDTO findById(Long jogoId) {
        return toJogoDTO(jogoRepository.findById(jogoId).orElseThrow());
    }
}
