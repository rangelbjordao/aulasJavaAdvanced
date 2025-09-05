package br.com.pacaembu.proximojogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadioService {

    @Autowired
    private JogoRepository repository;

    public Jogo proximoJogo() {
        //acessar um repository para ter acesso aos dados
        List<Jogo> lista = repository.findAll();
        if (lista.isEmpty()) {
            return new Jogo();
        }
        Jogo last = lista.get(lista.size()-1);
        return last;
    }

    public Jogo salvarProximoJogo(Jogo jogo) {
        Jogo jogoSalvo = repository.save(jogo);
        return jogoSalvo;
    }

}
