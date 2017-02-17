package sample.domain;

import java.sql.Date;
import java.util.Calendar;

/**
 * Created by marek on 02.01.17.
 */

public class MyCalendar {

    private Calendar c = Calendar.getInstance();

    public MyCalendar(){

    }

    public MyCalendar(Calendar c) {
        this.c = c;
    }

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }

    public void setMyCalendarSqlDate(java.sql.Date date ){
        c.setTime(date);
    }

    public void setMyCalendarUlitDate(java.util.Date date){
        c.setTime(date);
    }

    /**Returns current Calendar date in sql format*/
    public Date getSqlDate(){
        zeroTimeCalendar(c);
        java.util.Date utilDate = c.getTime();
        java.sql.Date sqlDate = new Date(utilDate.getTime());
        return sqlDate;
    }

    public java.sql.Date add(int number){

        c.add(Calendar.DATE, number);
        return getSqlDate();

    }

    public Date[] generateWeekFromToDay(){

        MyCalendar myCalendar = new MyCalendar();
        Date[] week = new Date[7];
        week[0] = myCalendar.getSqlDate();

        for (int i = 1; i < 7; i++) {
            week[i] = myCalendar.add(1);
        }

        return week;
    }

    public Date[] generateWeekFromDate(java.sql.Date beginDate){

        MyCalendar myCalendar = new MyCalendar();
        myCalendar.setMyCalendarSqlDate(beginDate);
        Date[] week = new Date[7];
        week[0] = myCalendar.getSqlDate();

        for (int i = 1; i < 7; i++) {
            week[i] = myCalendar.add(1);
        }

        return week;
    }

    public Date toDay(){
        MyCalendar myCalendar = new MyCalendar();
        return myCalendar.getSqlDate();
    }

    private void zeroTimeCalendar(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND,0);
    }



}
