package ir.golestan.model;

import javax.persistence.*;

/**
 * Created by Reza-PC on 5/28/2017.
 */

@Entity
public class CourseTimeInweak {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id ;
    @Column
    private int day ;
    @Column
    private int startHour;
    @Column
    private int startMin ;
    @Column
    private int endHour ;
    @Column
    private int endMin ;

    public CourseTimeInweak(){

    }

    public CourseTimeInweak(int day, int startHour, int startMin, int endHour, int endMin) {
        setDay(day);
        setEndHour(endHour);
        setEndMin(endMin);
        setStartHour(startHour);
        setStartMin(startMin);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(0<=day&&day<7)
        this.day = day;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        if(6<startHour&&startHour<20)
        this.startHour = startHour;
    }

    public int getStartMin() {
        return startMin;
    }

    public void setStartMin(int startMin) {
        this.startMin = startMin;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMin() {
        return endMin;
    }

    public void setEndMin(int endMin) {
        this.endMin = endMin;
    }
    public int GetDuring(){
       return endHour*60+endMin-startHour*60-startMin;
    }
}
