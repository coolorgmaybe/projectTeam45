package com.javathon.projectTeam45.services;

import com.javathon.projectTeam45.entity.Basket;
import com.javathon.projectTeam45.entity.EatTime;
import com.javathon.projectTeam45.entity.Items;
import com.javathon.projectTeam45.entity.ShopItems;
import com.javathon.projectTeam45.repos.*;
import com.javathon.projectTeam45.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {

    @Autowired
    private EatTimeRepo eatTimeRepo;

    @Autowired
    private EatRepo eatRepo;

    @Autowired
    private BasketRepo basketRepo;

    @Autowired
    private ItemsRepo itemsRepo;

    @Autowired
    private ShopsItemsRepo shopItemsRepo;

    public List<ShopItems> getShops(Long userId) {
        final List<EatTime> eatTimes = eatTimeRepo.findByuserId(userId);

        String currentTime = DateUtils.getCurrentTime();

        Long eatTimeId = eatTimes.stream().filter(x -> Long.parseLong(x.getStart()) >= Long.valueOf(currentTime)
                                                        && Long.valueOf(x.getEnd()) <= Long.valueOf(currentTime))
                                                        .collect(Collectors.toList()).get(0).getEatTimeId();
        String eatName = eatRepo.findById(eatTimeId).get().getName();

        List<Basket> baskets = basketRepo.findByEatTimeId(eatTimeId);

        List<Long> ids = baskets.stream().map(Basket::getItemId).collect(Collectors.toList());

        List<Items> items = itemsRepo.findAllById(ids);

//        List<List<ShopItems>> a = items.stream().map(x -> shopItemsRepo.findAllByItemId(x.getId()))
//                .map(x -> x.stream().map(k -> k.));
//
//        shopItemsRepo.findAll().stream()
//                .filter(x -> items.contains(x.getItemId()))
//                .collect(Collectors.groupingBy(x -> x.getShopId(), Collectors.counting()));



        return Collections.EMPTY_LIST;
    }

}
