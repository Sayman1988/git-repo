package com.finance.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
@EnableHystrixDashboard
public class MonitoringApplication {
  /* Before starting the Monitoring service, run RabbitMQ with next command:
  * cmd C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.0\sbin>rabbitmq-server start
  * */
	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}
}
