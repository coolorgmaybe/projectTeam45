package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemsRepo extends JpaRepository<Items, Long> {
    @Override
    Optional<Items> findById(Long itemId);

    @Override
    List<Items> findAllById(Iterable<Long> iterable);
}
