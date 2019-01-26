package com.javathon.projectTeam45.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * This is list of items connected with shop by shop_Id.
 */

@Entity
public class ShopItems {

    public ShopItems() { }

    @Column(name = "shop_id")
    private String shopId;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Long price;

    public String getShopItem() {
        return shopId;
    }

    public void setShopItem(String shopItem) {
        this.shopId = shopItem;
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
        return price;
    }

    public void setPrive(Long prive) {
        this.price = prive;
    }
}