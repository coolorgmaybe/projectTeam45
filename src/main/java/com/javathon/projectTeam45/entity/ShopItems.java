package com.javathon.projectTeam45.entity;

import javax.persistence.*;

/**
 * Класс, отвечающий за создание датамодели айтемов, принадлежащих конкретному магазину
 */

@Entity
@Table(name = "shopItems")
public class ShopItems {

    public ShopItems() { }

    @Id
    @JoinColumn(name = "shop_id")
    private Long shopId;

    @JoinColumn(name = "item_id")
    private Long itemId;

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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
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