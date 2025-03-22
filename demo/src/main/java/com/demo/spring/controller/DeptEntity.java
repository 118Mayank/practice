package com.demo.spring.controller;

import java.util.List;

public class DeptEntity {
	
	
	Long id;
	
	@OneToMany(mappedBy ="deptEntity")
	List<DeptEntity> empEntity;

}
