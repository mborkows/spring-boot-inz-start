package sample.domain;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by marek on 16.11.16.
 */
public class TermForm {

    private int employee_id;
    private Date day;
    private Time begin_time;
    private Time end_time;

    public TermForm(){

    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public Date getDay_id() {
        return day;
    }

    public void setDay_id(Date day) {
        this.day = day;
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
