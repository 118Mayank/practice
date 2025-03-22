package com.demo.spring.controller;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.*;

@EntityScan
public class EmpEntity {

	Long id;


	@ManyToOne
	@JoinColumn(name = "department_id")
	DeptEntity deptEntity;
}
