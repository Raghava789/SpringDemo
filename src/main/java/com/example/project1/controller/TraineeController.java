package com.example.project1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.project1.bean.Trainee;
import com.example.project1.service.ITraineeService;
@RestController
public class TraineeController {
	@Autowired
	ITraineeService traServ;
	
	@GetMapping("/trainees")
	List<Trainee> getAllTrainee(){
		return traServ.getAllTrainee();
	}
	@PostMapping("/trainees")
	Trainee addTrainee(@RequestBody Trainee trainee) {
		return traServ.addTrainee(trainee);
	}
	@GetMapping("/trainees/{id}")
	Trainee getTraineeById(@PathVariable("id") int id) {
		return traServ.getTraineeById(id);
	}

}
