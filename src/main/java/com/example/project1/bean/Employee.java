package com.example.project1.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
	@Id
	@GeneratedValue
	private int empId;
	
	@NotEmpty
	@Size(min = 3, message = "minimum required char are 3")
	private String empName;
	private double salary;
	private String contactNo;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "loginId")
	private Login login;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="empId")
	private List<Address> address;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
		name = "employee_skill", 
		joinColumns = { @JoinColumn(name = "emp_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "skill_id") }
	)
	private List<Skill> skills;
	

	
	
}
