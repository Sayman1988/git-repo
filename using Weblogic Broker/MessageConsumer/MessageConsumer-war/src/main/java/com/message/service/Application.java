package com.message.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * Created by seroole on 3/31/2017.
 */

@SpringBootApplication
@EnableJms
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
