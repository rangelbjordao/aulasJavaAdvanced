package br.com.fiap.rh.api.service;

import br.com.fiap.rh.api.dto.EmployeeDTO;
import br.com.fiap.rh.api.dto.EntryTagDTO;
import br.com.fiap.rh.api.model.Employee;
import br.com.fiap.rh.api.model.EntryTag;
import br.com.fiap.rh.api.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Page<EmployeeDTO> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(this::toDto);
    }

    private EmployeeDTO toDto(Employee savedEmployee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(savedEmployee.getId());
        employeeDTO.setName(savedEmployee.getName());
        employeeDTO.setEmail(savedEmployee.getEmail());
        employeeDTO.setAge(savedEmployee.getAge());
        employeeDTO.setEntryTag(toEntryTagDTO(savedEmployee.getEntryTag()));
        return employeeDTO;
    }

    private EntryTagDTO toEntryTagDTO(EntryTag entryTag) {
        if (entryTag == null)
            return null;
        EntryTagDTO entryTagDTO = new EntryTagDTO();
        entryTagDTO.setHashTag(entryTag.getHashTag());
        return entryTagDTO;
    }

}
