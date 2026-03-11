package br.com.fiap.rh.api.dto;

import br.com.fiap.rh.api.model.EntryTag;
import lombok.Data;

import java.util.UUID;

@Data
public class EmployeeDTO {
    private long id;
    private String name;
    private String email;
    private int age;
    private EntryTagDTO entryTag;
}
