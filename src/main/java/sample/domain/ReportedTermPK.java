package sample.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by marek on 14.11.16.
 */
@Embeddable
public class ReportedTermPK implements Serializable {

    private Employee employee;
    private Day day;

    @ManyToOne
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    @ManyToOne
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
