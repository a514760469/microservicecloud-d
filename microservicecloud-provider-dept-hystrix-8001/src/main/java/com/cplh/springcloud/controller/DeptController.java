package com.cplh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cplh.springcloud.entity.Dept;
import com.cplh.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}
	
	@GetMapping("/dept/get/{id}")
	@HystrixCommand(fallbackMethod = "hystrixGet")
	public Dept get(@PathVariable("id") Long id) {
		Dept dept = deptService.get(id);
		if(dept == null) {
			throw new RuntimeException("异常出现：" + id + "不存在");
		}
		return dept;
	}
	
	@GetMapping("/dept/list")
	public List<Dept> list() {
		return deptService.list();
	}
	
	@GetMapping("/dept/discovery")
	public Object getDiscovery() {
		List<String> services = discoveryClient.getServices();
		System.out.println("=>" + services);
		List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance serviceInstance : instances) {
			System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() 
			+ "\t" + serviceInstance.getPort() + "\t" + serviceInstance.getUri() + "\t" + serviceInstance.getMetadata());
		}
		return this.discoveryClient;
	}
	
	
	public Dept hystrixGet(@PathVariable("id") Long id) {
		
		return new Dept().setDname("该" + id + "没有对应的信息");
	}
}




