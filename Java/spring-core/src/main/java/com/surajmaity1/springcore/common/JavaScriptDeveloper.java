package com.surajmaity1.springcore.common;

public class JavaScriptDeveloper implements Developer{
    public JavaScriptDeveloper() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String writeCode() {
        return "Write JS Code";
    }
}
