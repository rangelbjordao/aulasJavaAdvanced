package br.com.pacaembu.proximojogo.service;

import br.com.pacaembu.proximojogo.model.Jogo;
import br.com.pacaembu.proximojogo.dto.JogoDTO;
import br.com.pacaembu.proximojogo.repository.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadioService {

    private JogoRepository repository;

    public JogoDTO proximoJogo() {
        List<Jogo> lista = repository.findAll();
        if (lista.isEmpty()) {
            return new JogoDTO();
        }
        Jogo last = lista.get(lista.size()-1);
        return toDTO(last);
    }

    public JogoDTO salvarProximoJogo(JogoDTO jogo) {
        Jogo jogoSalvo = repository.save(toEntity(jogo));
        return toDTO(jogoSalvo);
    }

    private static JogoDTO toDTO(Jogo jogo) {
        JogoDTO dto = new JogoDTO();
        dto.setId(jogo.getId());
        dto.setMataMata(jogo.getMataMata());
        return dto;
    }

    private static Jogo toEntity(JogoDTO dto) {
        Jogo entity = new Jogo();
        entity.setId(dto.getId());
        entity.setMataMata(dto.getMataMata());
        return entity;
    }

}
