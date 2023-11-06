package com.surajmaity1.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class JavaDeveloper implements Developer{
    public JavaDeveloper() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String writeCode() {
        return "Write Java Code";
    }
}
