package br.com.pacaembu.proximojogo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 50)
    private String mataMata;

    @ManyToOne
    @JoinColumn(name = "id_estadio")
    private Estadio estadio;

//    @Column(nullable = false, length = 50)
//    private String nomeEstadio;
//
//    private Integer capacidadeEstadio;
}
