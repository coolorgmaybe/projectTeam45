package restcontrollers;

import entity.Test;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.TestService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeRest {
    private TestService testService;

    @GetMapping("/employees/{employeeId}")
    public List<Test> getTest() {
        return testService.findAll();
    }
}
