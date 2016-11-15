package sample.domain;

/*
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;
*/

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Time;

/**
 * Created by marek on 09.11.16.
 */

@Entity
@AssociationOverrides({
        @AssociationOverride(name = "pk.employee",
                joinColumns = @JoinColumn(name = "employee_id")),
        @AssociationOverride(name = "pk.day",
                joinColumns = @JoinColumn(name = "day_id")) })
public class ReportedTerm implements Serializable {

    private ReportedTermPK pk = new ReportedTermPK();
    private Time beginTime;
    private Time endTime;

    public ReportedTerm(){
    }

    public ReportedTerm(Time beginTime, Time endTime) {
        this.beginTime = beginTime;
        this.endTime = endTime;
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

    public Time getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Time beginTime) {
        this.beginTime = beginTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

}
