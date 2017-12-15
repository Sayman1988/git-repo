package com.projectx.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * Created by o.serohin on 03.11.2017.
 */

@SpringBootApplication
@EnableEurekaServer
public class RegistryApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RegistryApplication.class, args);
    }
}