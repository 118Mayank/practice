package com.demo.spring.controller;

public class TestOne {
	
	public static void main(String arg[]) {
		
		Employees employees1=new Employees(2,"raj",30);
		Employees employees2=new Employees(3,"ram",35);
		
		System.out.println(employees1.compareTo(employees2));
	}

}
