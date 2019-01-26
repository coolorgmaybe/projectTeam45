package repos;

import entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepo extends JpaRepository<Test, Long> {
    @Override
    List<Test> findAll();
}
