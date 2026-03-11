package br.com.pacaembu.proximojogo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID uuid;

    public String mensagem;
}
