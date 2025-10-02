package com.fiap.revisao.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.*;

@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_medico")
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nomeCompleto;
    private String crm;

    @ManyToMany
    @JoinTable(name = "tb_medico_especialidade",
            joinColumns = @JoinColumn(name = "id_medico"),
            inverseJoinColumns = @JoinColumn(name = "id_especialidade"))
    private Set<Especialidade> especialidades = new HashSet<>();

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarEspecialidade(Especialidade e) {
        especialidades.add(e);
        e.getMedicos().add(this);
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
        consulta.setMedico(this);
    }
}
