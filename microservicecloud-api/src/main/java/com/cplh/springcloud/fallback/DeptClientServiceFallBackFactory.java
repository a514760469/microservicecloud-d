package com.cplh.springcloud.fallback;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cplh.springcloud.entity.Dept;
import com.cplh.springcloud.service.DeptClientService;

import feign.hystrix.FallbackFactory;
/**
 * 加@Component
 */
@Component
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {

		return new DeptClientService() {

			@Override
			public boolean add(Dept dept) {
				return false;
			}

			@Override
			public Dept get(Long id) {
				return new Dept().setDeptno(id).setDname("该" + id + "没有对应的信息, 此服务已关闭").setDb_source("No DBSource");
			}

			@Override
			public List<Dept> list() {
				return null;
			}
			
		};
	}

}
