package com.finance.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
@EnableHystrixDashboard
public class MonitoringApplication {
  /*TODO fix connection to Command Metric Stream, details below
  * Unable to connect to Command Metric Stream
  * ashboardConfiguration$ProxyStreamServlet : Error proxying request: http://localhost:8989/turbine.stream?cluster=HYSTRIX-AGGREGATE
  *
  * http://localhost:8989/turbine.stream?cluster=HYSTRIX-AGGREGATE is a working Turbine stream endpoint, ping is fine
  * Before starting the Monitoring service, run RabbitMQ with next command:
  * cmd C:\Program Files\RabbitMQ Server\rabbitmq_server-3.7.0\sbin>rabbitmq-server start
  * */
	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}
}
