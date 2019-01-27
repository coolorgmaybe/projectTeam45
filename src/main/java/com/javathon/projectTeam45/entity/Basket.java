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
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "user_id can not be empty")
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "item_id can not be empty")
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "eat_time_id")
    private Long eatTimeId;


    public Long getUserId() {
        return itemId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getEatTime() {
        return eatTimeId;
    }

    public void setEatTime(Long eatTimeId) {
        this.eatTimeId = eatTimeId;
    }
}