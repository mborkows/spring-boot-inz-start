package sample.domain;

/*
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;
import javax.persistence.Table;
*/

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by marek on 09.11.16.
 */

@Entity
@Table(name = "reported_term")
@AssociationOverrides({
        @AssociationOverride(name = "pk.employee",
                joinColumns = @JoinColumn(name = "employee_id")),
        @AssociationOverride(name = "pk.day",
                joinColumns = @JoinColumn(name = "day_id")) })
public class ReportedTerm implements Serializable {

    private ReportedTermPK pk = new ReportedTermPK();
    private Time begin_time;
    private Time end_time;

    public ReportedTerm(){
    }

    public ReportedTerm(Time begin_time, Time end_time) {
        this.begin_time = begin_time;
        this.end_time = end_time;
    }

    @EmbeddedId
    public ReportedTermPK getPk() {
        return pk;
    }

    public void setPk(ReportedTermPK pk) {
        this.pk = pk;
    }

    @Transient
    public Employee getEmployee(){
        return pk.getEmployee();
    }

    public void setEmployee(Employee employee){
        pk.setEmployee(employee);
    }

    @Transient
    public Day getDay() {
        return pk.getDay();
    }

    public void setDay(Day day){
        pk.setDay(day);
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

}
