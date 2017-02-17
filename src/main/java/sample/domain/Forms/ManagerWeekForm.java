package sample.domain.Forms;

import sample.domain.Declaration;
import sample.domain.Employee;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 * Created by marek on 02.01.17.
 */
public class ManagerWeekForm {

    private Boolean declarations[][];
    private Boolean approved[][];
    private int id[][];
//    private Date[] week;
//    private List<Employee> workers;

    public ManagerWeekForm() {

    }

    public ManagerWeekForm(List<Employee> workers, List<List<Declaration>> declarationsArray, Date[] week) {
        this.declarations = new Boolean[workers.size()][21];
        this.approved = new Boolean[workers.size()][21];
        this.id = new int[workers.size()][21];


        prepareDeclaration();
        prepareApproved();

        for (List<Declaration> list : declarationsArray) {
            for (Declaration d : list) {
                int tmp = matchWeekDay(week, d) * 3 + matchHour(d);
                declarations[declarationsArray.indexOf(list)][tmp] = true;
                id[declarationsArray.indexOf(list)][tmp] = d.getId();
                if (d.isApproved())
                    approved[declarationsArray.indexOf(list)][tmp] = true;
            }
        }
    }

    public Boolean[][] getDeclarations() {
        return declarations;
    }

    public void setDeclarations(Boolean[][] declarations) {
        this.declarations = declarations;
    }

    public Boolean[][] getApproved() {
        return approved;
    }

    public void setApproved(Boolean[][] approved) {
        this.approved = approved;
    }

    public int[][] getId() {
        return id;
    }

    public void setId(int[][] id) {
        this.id = id;
    }

//    public Date[] getWeek() {
//        return week;
//    }
//
//    public void setWeek(Date[] week) {
//        this.week = week;
//    }
//
//    public List<Employee> getWorkers() {
//        return workers;
//    }
//
//    public void setWorkers(List<Employee> workers) {
//        this.workers = workers;
//    }

    private int matchWeekDay(Date[] week, Declaration declarations) {

        for (int i = 0; i < week.length; i++) {
            if (week[i].equals(declarations.getDay()))
                return i;
        }

        return 0;
    }

    private int matchHour(Declaration declarations) {
        if (declarations.getBegin_time().equals(Time.valueOf("00:00:00"))) {
            return 0;
        } else if (declarations.getBegin_time().equals(Time.valueOf("08:00:00"))) {
            return 1;
        } else if (declarations.getBegin_time().equals(Time.valueOf("16:00:00"))) {
            return 2;
        }

        System.err.println("ManagerWeekForm->matchHour function error");
        return 0;
    }

    private void prepareApproved() {
        for (int i = 0; i < approved.length; i++) {
            for (int j = 0; j < 21; j++) {
                approved[i][j] = false;
            }
        }
    }

    private void prepareDeclaration(){
        for (int i = 0; i < declarations.length; i++) {
            for (int j = 0; j < 21; j++) {
                declarations[i][j] = false;
            }
        }
    }
}
