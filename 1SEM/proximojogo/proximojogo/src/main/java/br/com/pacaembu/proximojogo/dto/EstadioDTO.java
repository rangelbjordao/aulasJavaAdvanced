package br.com.pacaembu.proximojogo.dto;

import lombok.Data;

@Data
public class EstadioDTO {
    private Long id;
    private String nome;
    private Integer capacidade;
}
