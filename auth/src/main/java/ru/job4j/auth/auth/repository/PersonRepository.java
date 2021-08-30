package ru.job4j.auth.auth.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.auth.auth.entity.Person;

public interface PersonRepository extends CrudRepository<Person,Integer> {
}
