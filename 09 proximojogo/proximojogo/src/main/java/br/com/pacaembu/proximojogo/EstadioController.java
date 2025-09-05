package br.com.pacaembu.proximojogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proximojogo")
public class EstadioController {

    @Autowired
    private EstadioService estadioService;

    @GetMapping
    public ResponseEntity<?> proximoJogo() {
        Jogo nextGame = estadioService.proximoJogo();
        return new ResponseEntity<>(nextGame, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvarProximoJogo(@RequestBody Jogo jogo) {
        Jogo jogoSalvo = estadioService.salvarProximoJogo(jogo);
        return new ResponseEntity<>(jogoSalvo, HttpStatus.OK);
    }
}
