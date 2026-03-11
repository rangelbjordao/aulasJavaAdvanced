package br.com.pacaembu.proximojogo.controller;

import br.com.pacaembu.proximojogo.dto.ComentarioDTO;
import br.com.pacaembu.proximojogo.dto.JogoDTO;
import br.com.pacaembu.proximojogo.service.ComentarioService;
import br.com.pacaembu.proximojogo.service.JogoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proximojogo")
@AllArgsConstructor
public class JogoController {

    private JogoService jogoService;
    private ComentarioService comentarioService;

    @GetMapping
    public ResponseEntity<?> proximoJogo(
            @RequestParam(value = "idEstadio", required = false) Long idEstadio) {
        JogoDTO nextGame;
        if (idEstadio != null) {
            // Busca o próximo jogo filtrando por estádio
            nextGame = jogoService.proximoJogoPorEstadio(idEstadio);
        } else {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(nextGame, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvarProximoJogo(
            @Valid @RequestBody JogoDTO jogo, BindingResult bindingResults) {

        if (bindingResults.hasErrors()) {
            return new ResponseEntity<>(bindingResults.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        try {
            JogoDTO jogoSalvo = jogoService.salvarProximoJogo(jogo);
            return new ResponseEntity<>(jogoSalvo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/comentarios")
    public ResponseEntity<?> adicionarComentarios(
            @PathVariable() Long jogoId,
            @RequestBody
            @Valid
            ComentarioDTO comentarioDTO, BindingResult bindingResults) {
        if (bindingResults.hasErrors()) {
            return new ResponseEntity<>(bindingResults.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        JogoDTO jogoDTO = jogoService.findById(jogoId);

        JogoDTO.getComentarios().add(comentarioDTO);

        jogoService.atualizar(jogoDTO);

        ComentarioDTO comentarioDTOsalvo = comentarioService.salvarComentario(comentarioDTO);
        return new ResponseEntity<>(comentarioDTOsalvo, HttpStatus.OK);
    }
}
