package sample.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by marek on 28.11.16.
 */
@Entity
public class Role {

    private int id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<Employee> employees;

    public Role(){

    }

    public Role(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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

    public Collection<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<Employee> employees) {
        this.employees = employees;
    }
}
