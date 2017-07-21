package com.localhost;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Admin on 10.07.2017.
 */
@SpringBootApplication
@EnableScheduling
public class SpringBootETLApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootETLApp.class, args);
    }
}
