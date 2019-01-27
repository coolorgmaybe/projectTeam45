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
    @Column(name = "id")
    private Long id;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @JoinColumn(name = "eat_time_id")
    private Long eatTimeId;

    @Column(name = "start")
    private String start;

    @Column(name = "end")
    private String end;


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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}