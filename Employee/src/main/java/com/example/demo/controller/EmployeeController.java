package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping(value = "/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeServiceImpl.getAllEmployess());
		return "index";
	}
	@GetMapping(value = "/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	@PostMapping(value = "/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeServiceImpl.saveEmployee(employee);
		return "redirect:/";
	}
	@GetMapping(value = "/showFormForUpdate/{id}")
	public String updateEmployee(@PathVariable(value = "id") long id, Model model) {
		
		Employee employee = employeeServiceImpl.getEmployeeById(id);
		
		//to show employee form which is pre-populated
		model.addAttribute("employee", employee);
		return "update_employee";
	}
	@GetMapping(value = "/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") long id) {
		this.employeeServiceImpl.deleteEmployeeById(id);
		return "redirect:/";
		
	}

}
