package com.surajmaity1.springcore.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) // FOR SINGLETON -> ONE OBJECT WILL BE CREATED
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class JavaDeveloper implements Developer{
    public JavaDeveloper() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String writeCode() {
        return "Write Java Code";
    }
}
