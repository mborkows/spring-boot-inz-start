package sample.domain;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by marek on 22.11.16.
 */
@Entity
public class Declaration {

    private int id;
    private Time begin_time;
    private Time end_time;
    private Date day;

    @Column(columnDefinition="tinyint(1) default 0")
    private boolean approval;

    private Employee employee;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(Time begin_time) {
        this.begin_time = begin_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }

    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
