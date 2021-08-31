package ru.job4j.auth.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.job4j.auth.auth.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    /*@Query("SELECT DISTINCT employee FROM Employee e " +
            "JOIN FETCH e.persons")
    List<Employee> fetchEmployees();*/
}
