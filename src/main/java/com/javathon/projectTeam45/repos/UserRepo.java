package com.javathon.projectTeam45.repos;

import com.javathon.projectTeam45.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репо для поиска пользователей в БД
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String userName);

}
