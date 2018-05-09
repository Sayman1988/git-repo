package com.monitoring.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
@EnableHystrixDashboard
public class MonitoringApplication {
  /*
  The Hystrix stream: http://{$host}:{$port}/hystrix.stream
  The Hystrix Stream as a part of Turbine feature: http://localhost:8989/turbine.stream

  Before starting the Monitoring service, run RabbitMQ with next command:
  * cmd C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.0\sbin>
  * rabbitmq-plugins enable rabbitmq_management
  * rabbitmq-server start
  * */
	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}
}
