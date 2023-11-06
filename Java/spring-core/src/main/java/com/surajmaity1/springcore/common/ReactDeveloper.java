package com.surajmaity1.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class ReactDeveloper implements Developer{

    @Override
    public String writeCode() {
        return "Write React Code";
    }
}
