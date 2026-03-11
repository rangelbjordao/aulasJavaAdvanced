package br.com.fiap.rh.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Set;


@Data
@ToString
@Entity
@Table(name = "tb_knowledge")
public class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", length = 100, nullable = false)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_employee_knowledge",
    joinColumns = @JoinColumn(name = "id_knowledge"),
    inverseJoinColumns = @JoinColumn(name = "id_employee"))
    private Set<Employee> employeeSet;
}
