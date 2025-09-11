package br.com.pacaembu.proximojogo.controller;

import br.com.pacaembu.proximojogo.service.EstadioService;
import br.com.pacaembu.proximojogo.dto.JogoDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proximojogo")
@AllArgsConstructor
public class EstadioController {

    private EstadioService estadioService;

    @GetMapping
    public ResponseEntity<?> proximoJogo() {
        JogoDTO nextGame = estadioService.proximoJogo();
        return new ResponseEntity<>(nextGame, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvarProximoJogo(
            @Valid @RequestBody JogoDTO jogo,
            BindingResult bindingResults){

        if(bindingResults.hasErrors()) {
            return new ResponseEntity<>(bindingResults.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        JogoDTO jogoSalvo = estadioService.salvarProximoJogo(jogo);
        return new ResponseEntity<>(jogoSalvo, HttpStatus.OK);
    }

}
