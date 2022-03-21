package com.example.project1.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Login;
import com.example.project1.dto.EmpInputDto;
import com.example.project1.dto.EmpOutputDto;
import com.example.project1.repository.IEmployeeRepository;
import com.example.project1.service.EmployeeServiceImpl;

@ExtendWith(SpringExtension.class)
class EmployeeServiceMockitoTest {
	
	@InjectMocks
	EmployeeServiceImpl empService;
	
	@MockBean
	IEmployeeRepository empRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getEmpByIdTest() {
		Employee employee = new Employee();
		employee.setEmpId(35);
		employee.setEmpName("Jhon. K");
		employee.setContactNo("9876543220");
		Mockito.when(empRepo.findById(35)).thenReturn(Optional.of(employee));
		Employee emp = empService.getEmpById(35);
		assertEquals("9876543220", emp.getContactNo());
		assertEquals("Jhon. K", emp.getEmpName());
		//assertEquals(65000, emp.getSalary());
		assertEquals(35, emp.getEmpId());
	}
	
	@Test
	void addEmployeeTest() {
		EmpInputDto empInputDto = new EmpInputDto("Ram", "ram@gmail.com", "1234@ram", "9012345678");
		Employee emp =new Employee();
		emp.setEmpName(empInputDto.getEmpName());
		emp.setContactNo(empInputDto.getContactNo());
		Login login = new Login();
		login.setEmail(empInputDto.getEmail());
		login.setPassword(empInputDto.getPassword());
		emp.setLogin(login);
		
		Mockito.when(empRepo.save(emp)).thenReturn(emp);
		EmpOutputDto empOutputDto = empService.addEmployeeDto(empInputDto);
		assertEquals("Ram", empOutputDto.getEmpName());
		assertEquals("9012345678", empOutputDto.getContactNo());
		assertEquals("ram@gmail.com", empOutputDto.getEmail());
	}
	
	@Test
	void getEmpByNameTest() {
		Employee employee = new Employee();
		employee.setEmpId(35);
		employee.setEmpName("Jhon. K");
		employee.setContactNo("9876543220");
		Mockito.when(empRepo.findByEmpName("Jhon. K")).thenReturn(employee);
		
		Employee emp = empService.getEmpByName("Jhon. K");
		assertEquals("Jhon. K", emp.getEmpName());
		assertEquals("9876543220", emp.getContactNo());
	}
	
	@Test
	void deleteEmpById() {
		Employee employee = new Employee();
		employee.setEmpId(35);
		employee.setEmpName("Jhon. K");
		employee.setContactNo("9876543220");
		Mockito.when(empRepo.findById(35)).thenReturn(Optional.of(employee));
		
		Employee emp = empService.getEmpById(35);
		if(emp!= null) {
			assertEquals("Jhon. K", emp.getEmpName());
			assertEquals("9876543220", emp.getContactNo());
			//assertEquals("ram@gmail.com", emp.getLogin().getEmail());
			empService.deleteEmpById(emp.getEmpId());
		}
	}
	
	/*@Test
	void getEmpBySalaryTest() {
		Employee employee = new Employee();
		employee.setEmpId(38);
		employee.setEmpName("Jhon. K");
		employee.setContactNo("9876543220");
		employee.setSalary(45000);
		Mockito.when(empRepo.findById(38)).thenReturn(Optional.of(employee));
		Employee emp = empService.getEmpBySalary(45000);
		assertEquals("Jhon. K", emp.getEmpName());
		assertEquals("9876543220", emp.getContactNo());
	}*/

}
