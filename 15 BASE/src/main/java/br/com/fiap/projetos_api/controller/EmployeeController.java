package br.com.fiap.projetos_api.controller;


import br.com.fiap.projetos_api.dto.EmployeeDTO;
import br.com.fiap.projetos_api.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.hibernate.query.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of("id", "name", "age", "email");

    @GetMapping
    public Page<EmployeeDTO> getAllEmployees(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            @RequestParam(name = "order", defaultValue = "id,asc") String order) {
        Sort sort = parseMultiOrder(order);
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeService.getAllEmployees(pageable);
    }

    private Sort parseMultiOrder(String orderParam) {
        if (orderParam == null || orderParam.isBlank()) {
            return Sort.by(Sort.Order.asc("id"));
        }

        List<Sort.Order> orders = Arrays.stream(orderParam.split(";"))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(this::parseSingleOrder)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return orders.isEmpty() ? Sort.by(Sort.Order.asc("id")) : Sort.by(orders);
    }

    private Order parseSingleOrder(String part) {
        String[] tokens = part.split(";");
        String field = tokens[0].trim();

        if (!ALLOWED_SORT_FIELDS.contains(field)) {
            return null;
        }

        String dir = (tokens.length > 1 ? tokens[1].trim().toLowerCase() : "asc");
        return "desc".equals(dir) ? Order.desc(field) : Order.asc(field);
    }
}
