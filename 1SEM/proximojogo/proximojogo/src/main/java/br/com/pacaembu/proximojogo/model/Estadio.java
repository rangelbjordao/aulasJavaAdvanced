package br.com.pacaembu.proximojogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="tb_estadio")
public class Estadio {
    @Id
    private Long id;
    @Column(name="nome", nullable = false, length = 50)
    private String nome;
    @Column(name="capacidade", nullable = false, length = 50)
    private Integer capacidade;

}
