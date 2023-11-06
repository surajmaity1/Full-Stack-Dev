package com.surajmaity1.springcore.config;

import com.surajmaity1.springcore.common.Developer;
import com.surajmaity1.springcore.common.JavaScriptDeveloper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaScriptDeveloperConfig {
    @Bean("jsDevConf")
    public Developer javaScriptDeveloperConfig() {
        return new JavaScriptDeveloper();
    }
}
