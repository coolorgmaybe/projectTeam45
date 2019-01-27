package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.ShopItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopsItemsRepo extends JpaRepository<ShopItems, Long> {
    List<ShopItems> findAllByItemId(Long id);

    @Override
    List<ShopItems> findAll();
}