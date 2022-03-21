package com.example.project1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Trainee {
	
	@Id
	@GeneratedValue
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineeLocation;

}
