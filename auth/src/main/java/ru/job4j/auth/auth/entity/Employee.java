package ru.job4j.auth.auth.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private String UNN;
    private Timestamp hiringDate;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private Set<Person> persons = new HashSet<>();

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUNN() {
        return UNN;
    }

    public void setUNN(String UNN) {
        this.UNN = UNN;
    }

    public Timestamp getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Timestamp hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(UNN, employee.UNN) &&
                Objects.equals(hiringDate, employee.hiringDate) &&
                Objects.equals(persons, employee.persons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, UNN, hiringDate, persons);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", ID='" + UNN + '\'' +
                ", hiringDate=" + hiringDate +
                ", accounts=" + persons +
                '}';
    }
}
