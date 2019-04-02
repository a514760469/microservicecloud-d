package com.cplh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker // 开启熔断器
public class ApplicationDeptProviderHystrix_8001 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDeptProviderHystrix_8001.class, args);
	}
}
