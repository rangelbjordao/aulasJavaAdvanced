package br.com.pacaembu.proximojogo.controller;

import br.com.pacaembu.proximojogo.service.JogoService;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/proximojogo")
@AllArgsConstructor
public class JogoController {

    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<?> proximoJogo(
            @RequestParam(value = "idEstadio", required = false) Long idEstadio) {
        return null;
    }

    @PostMapping
    public ResponseEntity<?> salvarProximoJogo(
            @Valid @RequestBody JogoDTO jogo, BindingResult bindingResults){

        if(bindingResults.hasErrors()) {
            return new ResponseEntity<>(bindingResults.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        try {
            JogoDTO jogoSalvo = jogoService.salvarProximoJogo(jogo);
            return new ResponseEntity<>(jogoSalvo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
