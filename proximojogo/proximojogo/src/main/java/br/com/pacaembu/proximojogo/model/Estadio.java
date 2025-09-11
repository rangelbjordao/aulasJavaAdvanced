package br.com.pacaembu.proximojogo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estadio_seq_gen")
    @SequenceGenerator(
            name = "estadio_seq_gen",
            sequenceName = "estadio_seq",
            allocationSize = 1
    )
    private Long id;

    private String nome;

    private Integer capacidade;
}
