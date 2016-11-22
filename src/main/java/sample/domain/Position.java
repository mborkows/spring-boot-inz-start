package sample.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by marek on 22.11.16.
 */
@Entity
public class Position {

    private int id;
    private String name;
    private double salary;
    private Set<Employee> employees = new HashSet<Employee>();

    public Position(){

    }
    public Position(String name){
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @OneToMany(mappedBy = "position")
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

}
