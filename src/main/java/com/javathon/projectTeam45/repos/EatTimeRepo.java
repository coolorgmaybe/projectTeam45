package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.EatTime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EatTimeRepo extends JpaRepository<EatTime, Long> {
    List<EatTime> findByuserId(Long userId);
}
