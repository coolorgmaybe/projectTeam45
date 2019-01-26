package com.javathon.projectTeam45.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * This is list of items. Every item is a uniq element.
 */

@Entity
public class Items {

    public Items() { }

    @Column(name = "item_id")
    private String id;

    @Column(name = "item_name")
    private String itemsName;

    public String getItemsName() {
        return itemsName;
    }

    public void setItemsName(String itemsName) {
        this.itemsName = itemsName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}