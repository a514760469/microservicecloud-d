package com.cplh.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cplh.springcloud.entity.Dept;

@Mapper
public interface DeptDao {
	
	@Insert("INSERT INTO dept(dname,db_source) VALUES(#{dname},DATABASE())")
	public boolean addDept(Dept dept);

	@Select("select deptno,dname,db_source from dept where deptno=#{deptno}")
	public Dept findById(Long id);
	
	@Select("select deptno,dname,db_source from dept")
	public List<Dept> findAll();
	
}
