package com.surajmaity1.springcore.rest;

import com.surajmaity1.springcore.common.Developer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeveloperController {
    // define a private field for the dependency
    private Developer developer;

    // define a method for setter injection
    @Autowired
    public DeveloperController(@Qualifier("javaDeveloper") Developer developer) {
        System.out.println("In constructor: " + getClass().getSimpleName());
        this.developer = developer;
    }

    @GetMapping("/code")
    public String writeCode() {
        return developer.writeCode();
    }
}
