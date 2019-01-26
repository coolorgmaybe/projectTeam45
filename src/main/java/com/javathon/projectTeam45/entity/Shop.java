package com.javathon.projectTeam45.entity;

import javax.persistence.*;

/**
 * Класс, отвечающий за создание датамодели магазинов
 */
@Entity
@Table(name = "shop")
public class Shop {

    public Shop() { }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "shop_id")
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_location")
    private String shopLocation;

    @Column(name = "shop_priority")
    private Long priority;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}