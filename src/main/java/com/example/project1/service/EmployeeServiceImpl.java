package com.example.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Login;
import com.example.project1.bean.Skill;
import com.example.project1.dto.EmpInputDto;
import com.example.project1.dto.EmpOutputDto;
import com.example.project1.dto.EmployeeDto;
import com.example.project1.dto.LoginDto;
import com.example.project1.exception.EmployeeNotFoundException;
import com.example.project1.repository.IEmployeeRepository;
@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

	@Override
	public Employee getEmpById(int id) {
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+id);
		}
		return opt.get();
	}

	@Override
	public Employee getEmpByName(String name) {
		return empRepo.findByEmpName(name);
	}

	@Override
	public EmployeeDto addEmployee(Employee employee) {
		Employee emp = empRepo.save(employee);
		EmployeeDto empDto = new EmployeeDto();
		empDto.setEmpName(emp.getEmpName());
		empDto.setContactNo(emp.getContactNo());
		Login login =emp.getLogin();
		LoginDto loginDto= new LoginDto();
		loginDto.setEmail(login.getEmail());
		loginDto.setLogin(login.isLogin());
		
		empDto.setLoginDto(loginDto);
		
		return empDto;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee emp = empRepo.getById(employee.getEmpId());
		Optional<Employee> opt = empRepo.findById(employee.getEmpId());
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+employee.getEmpId());
		}
		return empRepo.save(employee);
	}

	@Override
	public Employee deleteEmpById(int id) {
		Employee emp = empRepo.getById(id);
		Optional<Employee> opt = empRepo.findById(id);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+id);
		}
		empRepo.deleteById(id);
		return opt.get();
	}

	@Override
	public Employee updateEmpByName(int empId, String name) {
		Employee emp = empRepo.getById(empId);
		Optional<Employee> opt = empRepo.findById(empId);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+empId);
		}
		else {
			emp.setEmpName(name);
			empRepo.save(emp);
			return emp;
		}
	}

	@Override
	public Employee updateEmpSalary(int id, double salary) {
		return null;
	}

	@Override
	public Employee getEmpBySalary(double salary) {
		Employee emp = empRepo.findBySalary(salary);
		Optional<Employee> opt = empRepo.findById(emp.getEmpId());
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given salary: "+salary);
		}
		return emp;
		
	}

	@Override
	public EmpOutputDto addEmployeeDto(EmpInputDto empInputDto) {
		// Convert EmpInputDto obj to Employee obj
		Employee emp = new Employee();
		emp.setEmpName(empInputDto.getEmpName());
		emp.setContactNo(empInputDto.getContactNo());
		//create Login object
		Login login = new Login();
		login.setEmail(empInputDto.getEmail());
		login.setPassword(empInputDto.getPassword());
		emp.setLogin(login);

		Employee newEmp= empRepo.save(emp);
		EmpOutputDto empOutputDto = new EmpOutputDto();
		empOutputDto.setEmpName(newEmp.getEmpName());
		empOutputDto.setContactNo(newEmp.getContactNo());
		empOutputDto.setEmail(newEmp.getLogin().getEmail());
				
		return empOutputDto;
	}

	@Override
	public Employee addSkillByEmpId(int empId, List<Skill> skills) {
		Optional<Employee> opt = empRepo.findById(empId);
		if(!opt.isPresent()) {
			throw new EmployeeNotFoundException("Employee not found with the given id: "+ empId);
		}
		Employee emp = opt.get();
		emp.setSkills(skills);
		return empRepo.save(emp);
	}

	
	
	

}
