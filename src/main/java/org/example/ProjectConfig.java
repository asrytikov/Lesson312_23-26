package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "org.example")
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }

    @Bean
    public LoggingAspect aspect(){
        return new LoggingAspect();
    }



}
