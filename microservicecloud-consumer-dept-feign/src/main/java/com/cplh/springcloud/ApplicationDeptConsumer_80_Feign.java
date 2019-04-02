package com.cplh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.cplh.springcloud")
@EnableEurekaClient
//@ComponentScan("com.cplh.springcloud")
public class ApplicationDeptConsumer_80_Feign {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDeptConsumer_80_Feign.class, args);
	}
}
