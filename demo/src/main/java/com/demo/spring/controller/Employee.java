package com.demo.spring.controller;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee implements Comparable<Employee> {

	long id;
	String empName;
	long empSalary;

	@Override
	public int hashCode() {
		return Objects.hash(empName, empSalary, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(empName, other.empName) && empSalary == other.empSalary && id == other.id;
	}

	@Override
	public int compareTo(Employee o) {
		return Long.compare(this.empSalary, o.empSalary);
//		if (this.empSalary == o.empSalary)
//			return 0;
//		else if (this.empSalary > o.empSalary)
//			return 1;
//		else
//			return -1;
	}

}
