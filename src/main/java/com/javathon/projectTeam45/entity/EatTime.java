package com.javathon.projectTeam45.entity;

import javax.persistence.*;

/**
 * КЛасс, отвечающий за создание датамодели для Времени приема пищи
 */

@Entity
@Table(name = "eatTime")
public class EatTime {

    public EatTime() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @JoinColumn(name = "eat_time_id")
    private Long eatTimeId;

    @Column(name = "start")
    private Long start;

    @Column(name = "end")
    private Long end;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getEatTimeId() {
        return eatTimeId;
    }

    public void setEatTimeId(Long eatTimeId) {
        this.eatTimeId = eatTimeId;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }
}