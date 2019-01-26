package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.Basket;
import com.javathon.projectTeam45.entity.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;

interface ShopsItemsRepo extends JpaRepository<ShopItems, Long> {

}