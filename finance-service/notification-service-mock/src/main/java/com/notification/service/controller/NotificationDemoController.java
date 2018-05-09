package com.notification.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Oleksandr Serohin
 */

@RestController
public class NotificationDemoController {

    @GetMapping(path = "/")
    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String index() {
        return getCanonicalClassName() + " | The current time is " + LocalDateTime.now();
    }

    @GetMapping(path = "/hello")
    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String hello() {
        return getCanonicalClassName() + " | Hello, " + System.getenv("USERNAME") + "!";
    }

    private String defaultFallbackMethod() {
        return getCanonicalClassName() + " | THE CUSTOM FALLBACK METHOD IS USED";
    }

    private String getCanonicalClassName(){
        return this.getClass().getCanonicalName().toUpperCase();
    }
}