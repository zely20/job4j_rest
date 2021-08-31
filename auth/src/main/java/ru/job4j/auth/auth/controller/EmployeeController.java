package ru.job4j.auth.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.auth.auth.entity.Employee;
import ru.job4j.auth.auth.entity.Person;
import ru.job4j.auth.auth.repository.EmployeeRepository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public List<Employee> findAll() {
        return StreamSupport.stream(
                employeeRepository.findAll().spliterator(), false
        ).collect(Collectors.toList());
    }

    @PostMapping("/")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(
                employeeRepository.save(employee),
                HttpStatus.CREATED
        );
    }
}
