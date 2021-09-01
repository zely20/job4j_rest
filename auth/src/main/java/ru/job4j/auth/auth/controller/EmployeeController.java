package ru.job4j.auth.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
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

    @Autowired
    private RestTemplate rest;

    private static final String API_PERSON = "http://localhost:8080/person/";
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

    @PostMapping("/account")
    public ResponseEntity<Person> addAccount(@RequestBody Person person) {
        Person rsl = rest.postForObject(API_PERSON, person, Person.class);
        return new ResponseEntity<>(
                rsl,
                HttpStatus.CREATED
        );
    }
}
