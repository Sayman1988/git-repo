package com.notification.service.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Random;

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
    public String hello(@RequestParam(value = "fallback", required = false) String fallback) {
        if (StringUtils.isNotBlank(fallback)){
            // Randomly throw exception to show how works the fallback method
            randomThrowException();
        }


        return getCanonicalClassName() + " | Hello, " + getUsername() + "!";
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

    private void randomThrowException(){
        int num = new Random().nextInt(10);
        if(num < 5) throw new RuntimeException();
    }
}