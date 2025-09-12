package br.com.pacaembu.proximojogo.service;


import br.com.pacaembu.proximojogo.model.Jogo;
import br.com.pacaembu.proximojogo.dto.JogoDTO;

import br.com.pacaembu.proximojogo.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



import static br.com.pacaembu.proximojogo.service.Mappings.toJogoDTO;
import static br.com.pacaembu.proximojogo.service.Mappings.toJogoEntity;

@Service
@AllArgsConstructor
public class JogoService {

    private JogoRepository jogoRepository;

    public JogoDTO salvarProximoJogo(JogoDTO jogoDTO) throws IllegalArgumentException {
        Jogo jogoEntity = toJogoEntity(jogoDTO);
        Jogo jogoSalvo = jogoRepository.save(jogoEntity);
        return toJogoDTO(jogoSalvo);
    }


}
