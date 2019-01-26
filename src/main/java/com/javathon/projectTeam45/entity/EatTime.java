package com.javathon.projectTeam45.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EatTime {

    public EatTime() { }

    @Column(name = "user_id")
    private String userId;

    @Column(name = "breakfast_start")
    private Long BreakfastStart;

    @Column(name = "breakfast_end")
    private Long BreakfastEnd;

    @Column(name = "lunch_start")
    private Long LunchStart;

    @Column(name = "lunch_end")
    private Long LunchEnd;

    @Column(name = "dinner_start")
    private Long DinnerStart;

    @Column(name = "dinner_end")
    private Long DinnerEnd;

    public String getUserId() {
        return userId;
    }

    public Long getBreakfastStart() {
        return BreakfastStart;
    }

    public void setBreakfastStart(Long breakfastStart) {
        BreakfastStart = breakfastStart;
    }

    public Long getBreakfastEnd() {
        return BreakfastEnd;
    }

    public void setBreakfastEnd(Long breakfastEnd) {
        BreakfastEnd = breakfastEnd;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getLunchStart() {
        return LunchStart;
    }

    public void setLunchStart(Long lunchStart) {
        LunchStart = lunchStart;
    }

    public Long getLunchEnd() {
        return LunchEnd;
    }

    public void setLunchEnd(Long lunchEnd) {
        LunchEnd = lunchEnd;
    }

    public Long getDinnerStart() {
        return DinnerStart;
    }

    public void setDinnerStart(Long dinnerStart) {
        DinnerStart = dinnerStart;
    }

    public Long getDinnerEnd() {
        return DinnerEnd;
    }

    public void setDinnerEnd(Long dinnerEnd) {
        DinnerEnd = dinnerEnd;
    }


}
