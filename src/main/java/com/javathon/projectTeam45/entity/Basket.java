package com.javathon.projectTeam45.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Класс, отвечающий за датамодель корзины пользователя
 */

@Entity
@Table(name = "basket")
public class Basket {

    public Basket() { }

    @Id
    @NotBlank(message = "user_id can not be empty")
    @Column(name = "user_id")
    private Long user_id;

    @NotBlank(message = "item_id can not be empty")
    @Column(name = "item_id")
    private Long item_id;

    @Column(name = "eat_time_id")
    private Long eatTimeId;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getEatTime() {
        return eatTimeId;
    }

    public void setEatTime(Long eatTimeId) {
        this.eatTimeId = eatTimeId;
    }
}