package sample.domain;

/*
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by marek on 07.11.16.
 */
@Entity
public class Employee implements Serializable {

    private int id;
    private String name;
    private String surname;
    private Date birthday;
    private String email;
    private Timestamp createTime;

    private Firm firm;
    private Position position;
    private Set<Declaration> declarations = new HashSet<Declaration>();

    protected Employee(){

    }

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getEmployee_id() {
        return id;
    }

    public void setEmployee_id(int id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @ManyToOne
    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    @ManyToOne
    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @OneToMany(mappedBy = "employee")
    public Set<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(Set<Declaration> declarations) {
        this.declarations = declarations;
    }
}
