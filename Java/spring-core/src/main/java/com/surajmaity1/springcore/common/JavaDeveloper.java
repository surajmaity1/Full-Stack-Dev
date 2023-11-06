package com.surajmaity1.springcore.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class JavaDeveloper implements Developer{
    public JavaDeveloper() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // define our init method
    @PostConstruct
    public void buildStartupTask() {
        System.out.println("In buildStartupTask(): " + getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void buildEndTask() {
        System.out.println("In buildEndTask(): " + getClass().getSimpleName());
    }
    @Override
    public String writeCode() {
        return "Write Java Code";
    }
}
