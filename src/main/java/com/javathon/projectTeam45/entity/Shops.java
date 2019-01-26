package com.javathon.projectTeam45.entity;

import com.javathon.projectTeam45.enums.Role;

import javax.persistence.*;
import java.util.Set;

/**
 * This is list of all shops connected with location.
 */
@Entity
public class Shops {

    private String id;

    private String shopName;

    private String shopLocation;

    private Long priority;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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