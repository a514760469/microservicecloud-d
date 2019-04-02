package com.cplh.ribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

/**
 * 自定义ribbon规则
 * 官网：这个类不能放在@ComponentScan 扫描的范围内，否则失效
 * @author Administrator
 */
@Configuration
public class ConsumerRuleConfig {

	@Bean
	public IRule rule() {
//		return new RoundRobinRule(); // 轮询
//		return new RandomRule(); // 随机
		return new ConsumerRandomRule();
//		return new RetryRule(); // 重试
	}
}
