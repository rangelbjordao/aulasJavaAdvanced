package com.fiap.revisao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_especialidade")
@EqualsAndHashCode(of = "id")
public class Especialidade {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;

    @ManyToMany(mappedBy = "especialidades")
    private Set<Medico> medicos = new HashSet<>();
}
