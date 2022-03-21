package com.example.project1.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Skill;
import com.example.project1.dto.EmpInputDto;
import com.example.project1.dto.EmpOutputDto;
import com.example.project1.dto.EmployeeDto;
import com.example.project1.service.IEmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	IEmployeeService empServ;
	
	@GetMapping("/employees")
	List<Employee> getAllEmployees(){
		return empServ.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	Employee getEmployeeById(@PathVariable("id") int empId) {
		return empServ.getEmpById(empId);
	}
	
	@PostMapping("/employees")
	EmployeeDto addEmployee(@Valid @RequestBody Employee emp) {
		return empServ.addEmployee(emp);
	}
	
	@PostMapping("/employees/dto")
	ResponseEntity<EmpOutputDto> addEmployeeDto(@Valid @RequestBody EmpInputDto emp) {
		EmpOutputDto newEmp =  empServ.addEmployeeDto(emp);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	@PostMapping("/employees/{empId}")
	ResponseEntity<Employee> addSkillByEmpId(@PathVariable("empId") int empId, @RequestBody List<Skill> skills) {
		Employee newEmp =  empServ.addSkillByEmpId(empId, skills);
		return new ResponseEntity<>(newEmp, HttpStatus.CREATED);//201 created
	}
	
	@DeleteMapping("/employees/{id}")
	Employee deleteEmployee(@PathVariable("id") int id){
		return empServ.deleteEmpById(id);
	}
	
	@PutMapping("/employees")
	ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		Employee updateEmp = empServ.updateEmployee(emp);
		return new ResponseEntity<>(updateEmp, HttpStatus.OK);
	}
	
	@PatchMapping("/employees/{id}")
	ResponseEntity<Employee> updateEmpName(@PathVariable("id") int empId, @RequestBody String name) {
		Employee emp = empServ.updateEmpByName(empId, name);
		return new ResponseEntity<>(emp, HttpStatus.OK); 
		
	}
	
	@GetMapping("/employees/byName/{name}")
	ResponseEntity<Employee> getEmpByName(@PathVariable("name") String empName){
		Employee emp = empServ.getEmpByName(empName);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	@GetMapping("employees/bySalary/{salary}")
	ResponseEntity<Employee> getEmpBySalary(@PathVariable("salary") double empSalary){
		Employee emp=empServ.getEmpBySalary(empSalary);
		return new ResponseEntity<>(emp, HttpStatus.OK);
	}
	
	
}
