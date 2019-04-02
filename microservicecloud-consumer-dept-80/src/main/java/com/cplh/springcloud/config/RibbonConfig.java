package com.cplh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.cplh.ribbon.ConsumerRuleConfig;

@Configuration
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT", configuration = ConsumerRuleConfig.class)
public class RibbonConfig {
	
	@Bean
	@LoadBalanced	// 客户端负载均衡
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/**
	 * 替换默认轮询规则
	 * @return
	 */
//	@Bean
//	public IRule rule() {
////		return new RoundRobinRule(); // 轮询
////		return new RandomRule(); // 随机
//		return new RetryRule(); // 重试
//	}
}
