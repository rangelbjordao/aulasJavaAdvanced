package br.com.fiap.rh.api.repository;

import br.com.fiap.rh.api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameEndingWith(String sufix);

    List<Employee> findByAgeGreaterThan(int age);//nao inclui idadeMinima

    List<Employee> findByAgeGreaterThanEqual(int age);//inclui idadeMinima

    long countByAgeGreaterThanEqual(int age);

}
