package services;

import entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.TestRepo;

import java.util.List;

@Service
public class TestService {
    private TestRepo testRepo;

    @Autowired
    public TestService(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    public List<Test> findAll() {
        return testRepo.findAll();
    }
}
