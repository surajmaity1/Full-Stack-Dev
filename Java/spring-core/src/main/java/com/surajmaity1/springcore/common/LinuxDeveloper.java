package com.surajmaity1.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class LinuxDeveloper implements Developer{
    public LinuxDeveloper() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String writeCode() {
        return "Write Bash Code";
    }
}
