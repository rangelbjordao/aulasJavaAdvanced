package com.fiap.revisao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@Table(name = "tb_prontuario")
public class Prontuario {

    @Id
    private UUID id;
    @Lob
    private String historico;

}
