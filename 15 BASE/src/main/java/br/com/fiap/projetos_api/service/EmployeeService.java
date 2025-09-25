package br.com.fiap.projetos_api.service;

import br.com.fiap.projetos_api.dto.EmployeeDTO;
import br.com.fiap.projetos_api.model.Employee;
import br.com.fiap.projetos_api.repository.EmployeeRepository;
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

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Page<EmployeeDTO> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable).map(this::toDto);
    }

    private EmployeeDTO toDto(Employee savedEmployee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(savedEmployee.getId());
        employeeDTO.setName(savedEmployee.getName());
        employeeDTO.setEmail(savedEmployee.getEmail());
        employeeDTO.setAge(savedEmployee.getAge());
        return employeeDTO;
    }

}
