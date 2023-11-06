package com.surajmaity1.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class JavaDeveloper implements Developer{

    @Override
    public String writeCode() {
        return "Write Java Code";
    }
}
