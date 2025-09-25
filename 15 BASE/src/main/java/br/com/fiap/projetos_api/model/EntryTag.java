package br.com.fiap.projetos_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_entry_tag")
@Data
public class EntryTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hashTag", length = 100, nullable = false)
    private String hashTag;
}
