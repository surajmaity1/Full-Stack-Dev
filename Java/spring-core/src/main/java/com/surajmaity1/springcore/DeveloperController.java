package com.surajmaity1.springcore;

import com.surajmaity1.file.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {
    // define a private field for the dependency
    private Developer developer;

    // define a constructor for dependency injection
    @Autowired
    public DeveloperController(Developer developer) {
        this.developer = developer;
    }

    @GetMapping("/code")
    public String writeCode() {
        return developer.writeCode();
    }

}
