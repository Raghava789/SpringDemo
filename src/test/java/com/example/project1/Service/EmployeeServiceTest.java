package com.example.project1.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Login;
import com.example.project1.bean.Skill;
import com.example.project1.dto.EmpInputDto;
import com.example.project1.dto.EmpOutputDto;
import com.example.project1.dto.EmployeeDto;
import com.example.project1.dto.LoginDto;
import com.example.project1.service.IEmployeeService;

@SpringBootTest
class EmployeeServiceTest {
	
	@Autowired
	IEmployeeService empService;

	@Test
	void getAllEmployeesTest() {
		List<Employee> employees = empService.getAllEmployees();
		int noOfEmployees = employees.size();
		assertEquals(3, noOfEmployees);
	}

	@Test
	void getEmployeeByIdTest() {
		Employee employee = empService.getEmpById(35);
		assertEquals("9876543220", employee.getContactNo());
		assertEquals("Jhon. K", employee.getEmpName());
		assertEquals(65000, employee.getSalary());
		assertEquals(35, employee.getEmpId());
	}
	
	@Test
	@Disabled
	void addEmployeeDtoTest() {
		
		EmpInputDto empDto = new EmpInputDto();
		empDto.setEmpName("Ram");
		empDto.setEmail("ram@gmail.com");
		empDto.setContactNo("9123456789");
		empDto.setPassword("1234@ram");
		EmpOutputDto empOutDto = empService.addEmployeeDto(empDto);
		
		assertEquals("9123456789", empOutDto.getContactNo());
		assertEquals("Ram", empOutDto.getEmpName());
		assertEquals("ram@gmail.com", empOutDto.getEmail());	
	}
	
	@Test
	@Disabled
	void getEmpByNameTest() {
		Employee employee = empService.getEmpByName("Ram");
		assertEquals("9123456789", employee.getContactNo());
		assertEquals("Ram", employee.getEmpName());
		assertEquals("ram@gmail.com", employee.getLogin().getEmail());
	}
	
	@Test
	@Disabled
	void deleteEmpByIdTest() {
		Employee employee = empService.getEmpById(51);
		if(employee!= null) {
			assertEquals("Ram", employee.getEmpName());
			assertEquals("9123456789", employee.getContactNo());
			assertEquals("ram@gmail.com", employee.getLogin().getEmail());
			empService.deleteEmpById(employee.getEmpId());
		}
	}
	
	@Test
	@Disabled
	void addEmployeeTest() {
		Employee employee = new Employee();
		employee.setEmpName("Raj");
		employee.setSalary(45000.0);
		employee.setContactNo("9988776655");
		Login login = new Login();
		login.setEmail("raj@gmail.com");
		login.setPassword("1234@raj");
		login.setLogin(false);
		employee.setLogin(login);
		EmployeeDto empp = empService.addEmployee(employee);
		
		assertEquals("9988776655", empp.getContactNo());
		assertEquals("Raj", empp.getEmpName());
		assertEquals("raj@gmail.com", empp.getLoginDto().getEmail());
	}
	
	@Test
	void updateEmpByName() {
		Employee employee = empService.getEmpByName("Raj");
		if(employee!=null) {
			employee.setEmpName("Raju");
			Employee emp = empService.updateEmployee(employee);
			assertEquals("Raju", emp.getEmpName());
		}
	}
	
	@Test
	void getEmpBySalaryTest() {
		Employee employee = empService.getEmpBySalary(45000);
		assertEquals("Raju", employee.getEmpName());
		assertEquals("9988776655", employee.getContactNo());
		assertEquals("raj@gmail.com", employee.getLogin().getEmail());
	}
}
