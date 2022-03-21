package com.example.project1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Skill {

	@Id
	@GeneratedValue
	private int id;
	private String skillName;
}
