package com.javathon.projectTeam45.services;

import com.javathon.projectTeam45.entity.Basket;
import com.javathon.projectTeam45.entity.Items;
import com.javathon.projectTeam45.repos.ItemsRepo;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    private ItemsRepo itemsRepo;

    @Autowired
    public ItemService(ItemsRepo itemsRepo) {
        this.itemsRepo = itemsRepo;
    }

    private Items item(Basket basket) {
        return itemsRepo.findById(basket.getItem_id()).get();
    }

    public List<Items> items(List<Basket> baskets) {
        return baskets.stream().map(this::item).collect(Collectors.toList());
    }
}