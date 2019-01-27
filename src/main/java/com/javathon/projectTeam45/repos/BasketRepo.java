package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BasketRepo extends JpaRepository<Basket, Long> {

    List<Basket> findByUserId(Long userId);

    @Override
    void delete(Basket basket);
}