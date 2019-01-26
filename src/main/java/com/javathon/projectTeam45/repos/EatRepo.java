package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.Eat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EatRepo extends JpaRepository<Eat, Long> {
    @Override
    Optional<Eat> findById(Long id);
}
