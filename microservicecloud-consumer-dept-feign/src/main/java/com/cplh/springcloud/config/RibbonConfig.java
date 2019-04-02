package com.cplh.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * feign 面向接口编程 ribbon面向RestTemplate
 * @author Administrator
 */
@Configuration
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
