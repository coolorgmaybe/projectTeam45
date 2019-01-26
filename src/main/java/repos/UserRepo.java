package repos;

import entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репо для поиска пользователей в БД
 */
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String userName);

}
