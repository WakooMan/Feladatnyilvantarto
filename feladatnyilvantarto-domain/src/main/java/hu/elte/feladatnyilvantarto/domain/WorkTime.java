package hu.elte.feladatnyilvantarto.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
@Entity
public class WorkTime {
    @Id
    @GeneratedValue
    public int id;
    private final ZonedDateTime startDate;
    private ZonedDateTime endDate;
    @ManyToOne
    private TimeMeasure timeMeasure;
    private int timeWorked;

    public WorkTime(TimeMeasure timeMeasure){
        this.timeMeasure=timeMeasure;
        startDate= ZonedDateTime.now();
    }

    public WorkTime() {
        startDate= ZonedDateTime.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void end(){
        endDate=ZonedDateTime.now();
        timeWorked=(int)startDate.until(endDate, ChronoUnit.MINUTES);

    }

    public int getTimeWorked() {
        return timeWorked;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public TimeMeasure getTimeMeasure() {
        return timeMeasure;
    }
}