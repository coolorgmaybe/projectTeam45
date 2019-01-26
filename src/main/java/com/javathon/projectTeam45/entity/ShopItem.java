package com.javathon.projectTeam45.entity;

import javax.persistence.Entity;

/**
 * This is list of items connected with shop by shop_Id.
 */

@Entity
public class ShopItem {

    private String shopItem;

    private String itemId;

    private Long count;

    private Long prive;

    public String getShopItem() {
        return shopItem;
    }

    public void setShopItem(String shopItem) {
        this.shopItem = shopItem;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getPrive() {
        return prive;
    }

    public void setPrive(Long prive) {
        this.prive = prive;
    }
}
