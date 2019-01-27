package com.javathon.projectTeam45.services;

import com.javathon.projectTeam45.entity.Basket;
import com.javathon.projectTeam45.entity.EatTime;
import com.javathon.projectTeam45.entity.Items;
import com.javathon.projectTeam45.repos.BasketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {

    private BasketRepo basketRepo;

    @Autowired
    public BasketService(BasketRepo basketRepo) {
        this.basketRepo = basketRepo;
    }

    public List<Basket> findByUserId(Long id) {
        return basketRepo.findByUserId(id);
    }



    public boolean addNewBasket(Basket basket) {
        Basket basketFromDb = basketRepo.findAllById(Collections.singletonList(basket.getUserId()))
                .stream()
                .filter(x -> x.getItemId().equals(basket.getItemId()))
                .collect(Collectors.toList()).get(0);

        if (basketFromDb != null) {
            return false;
        }

        basketRepo.save(basket);
        return true;
    }

    public void changeBasket(Basket basket, EatTime eatTimeId) {
        Basket basketFromDb = basketRepo.findAllById(Collections.singletonList(basket.getUserId()))
                .stream()
                .filter(x -> x.getItemId().equals(basket.getItemId()))
                .collect(Collectors.toList()).get(0);


        if (basketFromDb == null) { basketRepo.save(basket); }
        else {
            basketRepo.delete(basket);
            basketFromDb.setEatTimeId(eatTimeId.getEatTimeId());
            basketRepo.save(basketFromDb);
        }
    }

    public void changeBasket(Basket basket, Items item) {
        Basket basketFromDb = basketRepo.findAllById(Collections.singletonList(basket.getUserId()))
                .stream()
                .filter(x -> x.getItemId().equals(basket.getItemId()))
                .collect(Collectors.toList()).get(0);


        if (basketFromDb == null) { basketRepo.save(basket); }
        else {
            basketRepo.delete(basket);
            basketFromDb.setEatTimeId(item.getId());
            basketRepo.save(basketFromDb);
        }
    }
}