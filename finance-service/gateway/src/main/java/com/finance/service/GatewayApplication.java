package com.finance.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
public class GatewayApplication {
	/*TODO temporary service to monitor, need to disable monitoring when other specific services will be created
	* Don't forget to remove @EnableHystrix annotation in this case*/

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}
}
