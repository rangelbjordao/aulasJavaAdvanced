package br.com.pacaembu.proximojogo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class JogoDTO {
    private Long id;
    @NotBlank
    private String mataMata;
    @NotNull
    private EstadioDTO estadioDTO;

    private List<ComentarioDTO> comentarios;
}
