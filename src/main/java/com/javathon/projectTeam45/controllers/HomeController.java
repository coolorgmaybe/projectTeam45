package com.javathon.projectTeam45.controllers;

import com.javathon.projectTeam45.entity.ShopItems;
import com.javathon.projectTeam45.services.HomeService;
import com.javathon.projectTeam45.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/{userId}")
    public String home(@PathVariable("userId") Long userId, Model model) {
        Map<String, List<ShopItems>> map = homeService.getShops(userId);
        String name = map.keySet().iterator().next();
        List<ShopItems> shopItems = map.values().iterator().next();
        List<String> itemNames = shopItems.stream().map(x -> homeService.getItemName(x.getItemId())).collect(Collectors.toList());
        Map<String, Long> shopMap = new HashMap<>();
        for (int i = 0; i < shopItems.size(); i++) {
            shopMap.put(itemNames.get(i), shopItems.get(i).getPrice());
        }
        model.addAttribute("shopName", name);
        model.addAttribute("shopMap", shopMap);
        return "home";
    }

}