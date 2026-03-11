package br.com.pacaembu.proximojogo.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogo_seq_gen")
    @SequenceGenerator(
            name = "jogo_seq_gen",
            sequenceName = "jogo_seq",
            allocationSize = 1  //gere incremento de 1 insert
    )
    private Long id;

    @Column(name = "mata_mata", nullable = false, length = 50)
    private String mataMata;

    @ManyToOne
    @JoinColumn(name = "id_estadio", nullable = false)
    private Estadio estadio;

    @OneToMany
    @JoinColumn(name = "jogo_id")
    private List<Comentario> comentarios;

}