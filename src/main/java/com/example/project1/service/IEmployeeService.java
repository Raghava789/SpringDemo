package com.example.project1.service;

import java.util.List;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Skill;
import com.example.project1.dto.EmpInputDto;
import com.example.project1.dto.EmpOutputDto;
import com.example.project1.dto.EmployeeDto;

public interface IEmployeeService {

	List<Employee> getAllEmployees();
	Employee getEmpById(int Id);
	Employee getEmpByName(String name);
	EmployeeDto addEmployee(Employee employee);
	EmpOutputDto addEmployeeDto(EmpInputDto employee);
	Employee updateEmployee(Employee employee);
	Employee deleteEmpById(int id);
	Employee updateEmpByName(int empId, String name);
	Employee updateEmpSalary(int id, double salary);
	Employee getEmpBySalary(double salary);
	Employee addSkillByEmpId(int empId, List<Skill> skills);
}
