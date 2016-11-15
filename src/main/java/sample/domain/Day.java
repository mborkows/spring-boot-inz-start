package sample.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by marek on 09.11.16.
 */
@Entity
@Table(name = "day")
public class Day {

    private long day_id;
    private java.sql.Date day;
    private Status status;
    private Set<ReportedTerm> reportedTerms = new HashSet<ReportedTerm>(0);

    protected Day(){}

    @Id
    @Column(name = "id")
    public long getDay_id() {
        return day_id;
    }

    public void setDay_id(long day_id) {
        this.day_id = day_id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.day", cascade = CascadeType.ALL)
    public Set<ReportedTerm> getReportedTerms() {
        return reportedTerms;
    }

    public void setReportedTerms(Set<ReportedTerm> reportedTerms) {
        this.reportedTerms = reportedTerms;
    }



    private enum Status{
        open,
        close
    }
}
