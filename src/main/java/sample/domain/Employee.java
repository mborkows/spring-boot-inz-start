package sample.domain;

/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by marek on 07.11.16.
 */
@Entity
public class Employee implements Serializable {



    private int employee_id;
    private String name;
    private String surname;
    private String post;
    private int age;
    private Set<ReportedTerm> reportedTerms = new HashSet<ReportedTerm>();    //kolekcja unikalnych obiektow reportedTerms
    private Firm firm;

    protected Employee(){

    }

    public Employee(String name, String surname, String post, int age) {
        this.name = name;
        this.surname = surname;
        this.post = post;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @ManyToOne
    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.employee", cascade = CascadeType.ALL)
    public Set<ReportedTerm>   getReportedTerms() {
        return this.reportedTerms;
    }

    public void setReportedTerms(Set<ReportedTerm> reportedTerms) {
        this.reportedTerms = reportedTerms;
    }

    /*Stanowisko*/
//    public enum Post {
//        menager,
//        worker
//    }
}
