package com.fiap.revisao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;
    private String nomeCompleto;
    @OneToOne
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setPaciente(this);
    }
}