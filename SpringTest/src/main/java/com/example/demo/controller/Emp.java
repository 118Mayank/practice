package com.example.demo.controller;

public class Emp {
	Long id;
	String name;
	String department;
	long salary;
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}


	public Emp(Long id, String name, String department, long salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", department=" + department + ", salary=" + salary + "]";
	}

}