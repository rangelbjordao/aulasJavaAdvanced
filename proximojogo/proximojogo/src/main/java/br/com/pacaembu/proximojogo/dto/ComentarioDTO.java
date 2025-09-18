package br.com.pacaembu.proximojogo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class ComentarioDTO {

    private UUID uuid;

    @NotBlank
    private String mensagem;

}
