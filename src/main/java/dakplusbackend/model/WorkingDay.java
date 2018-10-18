package dakplusbackend.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkingDay {
    private Long id;
    private Employee employee;
    private LocalDate day;
    private LocalTime hourStarted;
    private LocalTime hourEnded;
    private boolean tookLunchBreak;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getHourStarted() {
        return hourStarted;
    }

    public void setHourStarted(LocalTime hourStarted) {
        this.hourStarted = hourStarted;
    }

    public LocalTime getHourEnded() {
        return hourEnded;
    }

    public void setHourEnded(LocalTime hourEnded) {
        this.hourEnded = hourEnded;
    }

    public boolean isTookLunchBreak() {
        return tookLunchBreak;
    }

    public void setTookLunchBreak(boolean tookLunchBreak) {
        this.tookLunchBreak = tookLunchBreak;
    }
}
