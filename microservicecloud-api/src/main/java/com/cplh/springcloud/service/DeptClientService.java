package com.cplh.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cplh.springcloud.entity.Dept;
import com.cplh.springcloud.fallback.DeptClientServiceFallBackFactory;
/**
 * 新建一个DeptClientServiceFallBackFactory
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {
	
	@PostMapping("/dept/add")
	public boolean add(Dept dept);

	@GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id);

	@GetMapping("/dept/list")
	public List<Dept> list();
	
}
