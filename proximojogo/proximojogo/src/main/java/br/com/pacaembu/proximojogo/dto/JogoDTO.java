package br.com.pacaembu.proximojogo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class JogoDTO {
    private Long id;
    @NotBlank
    private String mataMata;
}
