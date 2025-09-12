package br.com.pacaembu.proximojogo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estadio", nullable = false)
    private Estadio estadio;
}
