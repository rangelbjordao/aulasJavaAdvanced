package br.com.fiap.rh.api.model;

import br.com.fiap.rh.api.dto.EmployeeDTO;
import br.com.fiap.rh.api.dto.EntryTagDTO;
import br.com.fiap.rh.api.dto.KnowledgeDTO;

import java.util.HashSet;

public class Mapper {

    public static KnowledgeDTO toKnowledgeDto(Knowledge knowledge) {
        KnowledgeDTO knowledgeDTO = new KnowledgeDTO();
        knowledgeDTO.setName(knowledge.getNome());
        knowledgeDTO.setId(knowledge.getId());
        knowledgeDTO.setEmployeesSet(new HashSet<>());
        for (Employee e: knowledge.getEmployeeSet()) {
            knowledgeDTO.getEmployeesSet().add(toDto(e));
        }
        return knowledgeDTO;
    }

    public static EmployeeDTO toDto(Employee savedEmployee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(savedEmployee.getId());
        employeeDTO.setName(savedEmployee.getName());
        employeeDTO.setEmail(savedEmployee.getEmail());
        employeeDTO.setAge(savedEmployee.getAge());
        return employeeDTO;
    }

    public static EntryTagDTO toEntryTagDTO(EntryTag entryTag) {
        if (entryTag == null)
            return null;
        EntryTagDTO entryTagDTO = new EntryTagDTO();
        entryTagDTO.setHashTag(entryTag.getHashTag());
        return entryTagDTO;
    }
}
