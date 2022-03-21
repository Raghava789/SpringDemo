package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Skill;
import com.example.project1.service.ISkillService;

@RestController
public class SkillController {
	
	@Autowired
	ISkillService skillService;
	
	@PostMapping("/skills")
	ResponseEntity<Skill> addSkill(@RequestBody Skill skill) {
		Skill newSkill = skillService.addSkill(skill);
		return new ResponseEntity<>(newSkill, HttpStatus.OK);
	}
	
	@DeleteMapping("/skills/{id}")
	ResponseEntity<Skill> deleteSkill(@PathVariable("id") int id){
		Skill dSkill = skillService.deleteSkillById(id);
		return new ResponseEntity<>(dSkill, HttpStatus.OK);
	}
	
	@GetMapping("/skills")
	List<Skill> getAllEmployees(){
		return skillService.getAllSkills();
	}
	
	@GetMapping("/skills/{id}")
	Skill getSkillById(@PathVariable("id") int id) {
		return skillService.getSkillById(id);
	}

}
