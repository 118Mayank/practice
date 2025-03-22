package com.demo.spring.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employees implements Comparable<Employees>{

	Long id;
	String name;
	int age;

	public Employees(int i, String string, int j) {

	}

	@Override
	public int compareTo(Employees e) {
		if(this.Employees==e;
	}
}
