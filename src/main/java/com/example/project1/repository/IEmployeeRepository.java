package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1.bean.Employee;
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByEmpName(String name);
	Employee findBySalary(double salary);
	Employee findBySalaryGreaterThan(double salary);
}
