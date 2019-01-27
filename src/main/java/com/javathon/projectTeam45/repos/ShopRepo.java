package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShopRepo extends JpaRepository<Shop, Long> {
    @Override
    Optional<Shop> findById(Long id);
}
