package com.javathon.projectTeam45.entity;

import javax.persistence.*;

/**
 * Класс, отвечающий за создания датамодели отдельного элемента продукта
 */

@Entity
public class Items {

    public Items() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private Long id;

    @Column(name = "item_name")
    private String itemsName;

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}