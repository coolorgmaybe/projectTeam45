package com.javathon.projectTeam45.entity;

import javax.persistence.*;

/**
 * Класс, отвечающий за создание датамодели айтемов, принадлежащих конкретному магазину
 */

@Entity
public class ShopItems {

    public ShopItems() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long shopId;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "count")
    private Long count;

    @Column(name = "price")
    private Long price;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}