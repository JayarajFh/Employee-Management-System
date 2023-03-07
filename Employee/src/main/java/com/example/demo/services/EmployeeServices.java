package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeServices {
	List<Employee> getAllEmployess();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);

}
