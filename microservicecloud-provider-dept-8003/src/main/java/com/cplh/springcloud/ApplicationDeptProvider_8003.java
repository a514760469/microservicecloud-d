package com.cplh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
public class ApplicationDeptProvider_8003 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationDeptProvider_8003.class, args);
	}
}
