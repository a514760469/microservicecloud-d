package com.cplh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerDashboardApp_9001 {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerDashboardApp_9001.class, args);
		
	}
}
