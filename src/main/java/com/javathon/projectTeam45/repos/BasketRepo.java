package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BasketRepo extends JpaRepository<Basket, Long> {

    @Override
    List<Basket> findAllById(Iterable<Long> userIds);

    @Override
    void delete(Basket basket);
}