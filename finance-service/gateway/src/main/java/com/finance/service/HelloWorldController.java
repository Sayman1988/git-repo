package com.finance.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author Oleksandr Serohin
 */

@RestController
public class HelloWorldController {
    /*TODO remove this class when monitoring will be disabled*/
    @GetMapping(path = "/")
    @HystrixCommand(fallbackMethod = "defaultFallbackMethod")
    public String index() {
        return "Current time: " + LocalDateTime.now();
    }

    private String defaultFallbackMethod() {
        return "THE CUSTOM FALLBACK METHOD IS USED";
    }
}