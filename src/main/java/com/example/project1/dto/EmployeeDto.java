package com.example.project1.dto;

import com.example.project1.bean.Login;

import lombok.Data;
@Data
public class EmployeeDto {
	private String empName;
	private String contactNo;
	private LoginDto loginDto;

}
