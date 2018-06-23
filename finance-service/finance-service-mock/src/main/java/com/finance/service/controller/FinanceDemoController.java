package com.finance.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Oleksandr Serohin
 */
@RestController
public class FinanceDemoController {
    /*TODO EXPOSE ALL DOCKER IMAGES FROM 8080 + ENABLE MULTI INSTANTIATION + DEFAULT ZONES*/
    @Value("${spring.application.name}:${spring.application.instance_id:${random.value}}")
    private String instanceId;

    @GetMapping(path = "/")
    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String index() {
        return "INSTANCE ID: " + instanceId + ". Current time is " + LocalDateTime.now();
    }

    @GetMapping(path = "/hello")
    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String hello() {
        return "Hello, " + getUsername() + "! The Finance service instance id: " + instanceId;
    }

    private String defaultFallbackMethod() {
        return getCanonicalClassName() + " | THE CUSTOM FALLBACK METHOD IS USED";
    }

    private String getCanonicalClassName(){
        return this.getClass().getCanonicalName().toUpperCase();
    }

    private String getUsername(){
        final String username = System.getenv("USERNAME");
        return username == null ? "Anonymous" : username;
    }
}