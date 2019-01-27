package com.javathon.projectTeam45.services;

import com.javathon.projectTeam45.entity.Basket;
import com.javathon.projectTeam45.entity.EatTime;
import com.javathon.projectTeam45.entity.Items;
import com.javathon.projectTeam45.entity.ShopItems;
import com.javathon.projectTeam45.repos.*;
import com.javathon.projectTeam45.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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

    @Autowired
    private ShopRepo shopRepo;

    private List<ShopItems> getMinShops(Long userId) {
        List<EatTime> eatTimes = eatTimeRepo.findByUserId(userId);

        String currentTime = DateUtils.getCurrentTime().replace(":", "");



        Long eatTimeId = eatTimes.stream().filter(x -> Long.parseLong(x.getStart().replace(":", "")) <= Long.valueOf(currentTime)
                                                    && Long.valueOf(x.getEnd().replace(":", "")) >= Long.valueOf(currentTime))
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

        List<ShopItems> shopItems = shopItemsRepo.findAll().stream().filter(x -> items.
                                                stream().anyMatch(y -> y.getId().equals(x.getItemId())))
                                                .collect(Collectors.toList());

        Map<Long, List<ShopItems>> shopsWithCount = shopItems.stream().collect(Collectors.groupingBy(ShopItems::getShopId));

        Iterator<Map.Entry<Long, List<ShopItems>>> iter = shopsWithCount.entrySet().iterator();

        Map<Long, Long> map = new HashMap<>();

        while (iter.hasNext()) {
            Map.Entry<Long, List<ShopItems>> a = iter.next();
            for (ShopItems shopItems1 : a.getValue()) {
                if(shopItems1.getShopId().equals(a.getKey())) {
                    if(!map.containsKey(a.getKey())) {
                        map.put(a.getKey(), shopItems1.getPrice());
                    } else {
                        map.put(a.getKey(), shopItems1.getPrice() + map.get(a.getKey()));
                    }
                }
            }
        }
        Long minValue = map.values().stream().min(Long::compare).get();

        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            if(entry.getValue().equals(minValue)) {
                return shopsWithCount.get(entry.getKey());
            }
        }
        return null;
    }

    public Map<String, List<ShopItems>> getShops(Long userId) {
        List<ShopItems> list = getMinShops(userId);
        String name = list.stream().map(x -> shopRepo.findById(x.getShopId()).get().getShopName()).collect(Collectors.joining());
        Map<String, List<ShopItems>> result = new HashMap<>();
        result.put(name, list);
        return result;
    }

    public String getItemName(Long id)
    {
        return itemsRepo.findById(id).get().getItemsName();
    }
}
