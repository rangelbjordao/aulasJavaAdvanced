package br.com.fiap.projetos_api.dto;

import lombok.Data;

@Data
public class EmployeeDTO {
    private long id;
    private String name;
    private String email;
    private int age;
}
