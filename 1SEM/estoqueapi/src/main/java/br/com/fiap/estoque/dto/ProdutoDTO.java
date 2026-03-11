package br.com.fiap.estoque.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDTO {
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;
}
