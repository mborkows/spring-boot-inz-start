package sample.domain.Forms;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by marek on 10.12.16.
 */
public class UserWeekForm {

    private java.sql.Date week[] = new Date[7];
    private Boolean declaration[][] = new Boolean[7][3];
    private Boolean approved[][] = new Boolean[7][3];
    private int id[][] = new int[7][3];
    private boolean flag = true;

    private Calendar c = Calendar.getInstance();


    public UserWeekForm() {
        zeroTimeCalendar(c);
        for (int i = 0; i < 7; i++) {
            java.util.Date utilDate = c.getTime();
            java.sql.Date sqlDate = new Date(utilDate.getTime());
            week[i] = sqlDate;
            c.add(Calendar.DATE, 1);
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                declaration[i][j] = false;
                approved[i][j] = false;
            }
        }
    }


    public UserWeekForm(java.sql.Date date) {
        java.util.Date utilDate = new java.util.Date(date.getTime());
        c.setTime(utilDate);
        for (int i = 0; i < 7; i++) {
            utilDate =c.getTime();
            java.sql.Date sqlDate = new Date(utilDate.getTime());
            week[i] = sqlDate;
            c.add(Calendar.DATE, 1);
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                declaration[i][j] = false;
                approved[i][j] = false;
            }
        }
    }


    public Date[] getWeek() {
        return week;
    }

    /*Ustawiamy tydzien, w ktory pierwszym dniem jest dzien podany jako argument*/
    public void setWeek(Date toDay) {
        c.setTime(toDay);

        for (int i = 0; i < 8; i++) {
            this.week[i] = (Date) c.getTime();
            c.add(Calendar.DATE, 1);
        }
    }

    public Boolean[][] getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Boolean[][] declaration) {

        for(int i=0; i<7; i++){
            for(int j=0; j<3; j++){
                if(declaration[i][j] != null)
                    this.declaration[i][j] = declaration[i][j];
            }
        }

    }

    public Boolean[][] getApproved() {
        return approved;
    }

    public void setApproved(Boolean[][] approved) {

        for(int i=0; i<7; i++){
            for(int j=0; j<3; j++){
                if(approved[i][j] != null)
                    this.approved[i][j] = approved[i][j];
            }
        }

    }

    public int[][] getId() {
        return id;
    }

    public void setId(int[][] id) {
        this.id = id;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setCell(int i, int j){
        this.declaration[i][j] = !this.declaration[i][j];
    }

    private void zeroTimeCalendar(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
    }



}
