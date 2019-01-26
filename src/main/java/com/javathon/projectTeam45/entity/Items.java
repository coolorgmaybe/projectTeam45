package com.javathon.projectTeam45.entity;

import javax.persistence.Entity;

/**
 * This is list of items. Every item is a uniq element.
 */

@Entity
public class Items {

    private String id;

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
