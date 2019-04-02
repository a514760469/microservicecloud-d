package com.cplh.springcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${server.port}")
	private String port;
	
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServer;
	
	
	@GetMapping("/config")
	public String getConfig() {
		System.out.println("=======================================");
		System.out.println("application:" + applicationName + "\t eurekaServer:" + eurekaServer + "\t port:" + port);
		return "application:" + applicationName + "\t eurekaServer:" + eurekaServer + "\t port:" + port;
	}
	
}
