package com.javathon.projectTeam45.controllers;

import com.javathon.projectTeam45.entity.Basket;
import com.javathon.projectTeam45.entity.Items;
import com.javathon.projectTeam45.services.BasketService;
import com.javathon.projectTeam45.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/basket/{userId}")
    public String basket(@RequestParam(name = "userId") Long userId) {

        List<Basket> baskets = basketService.findByUserId(userId);
        List<Items> items = itemService.items(baskets);

        return "basket";
    }
}