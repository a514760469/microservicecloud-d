package com.cplh.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cplh.springcloud.entity.Dept;
import com.cplh.springcloud.service.DeptClientService;

@RestController
public class ConsumerController {

	@Autowired
	private DeptClientService clientService;
	
	@PostMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return clientService.add(dept);
	}
	
	@GetMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return clientService.get(id);
	}
	
	@GetMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return clientService.list();
	}
	
	
}
