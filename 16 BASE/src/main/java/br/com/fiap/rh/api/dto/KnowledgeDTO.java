package br.com.fiap.rh.api.dto;

import lombok.Data;

import java.util.Set;

@Data
public class KnowledgeDTO {
    private long id;
    private String name;
    private Set<EmployeeDTO> employeesSet;
}