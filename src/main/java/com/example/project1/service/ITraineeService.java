package com.example.project1.service;

import java.util.List;

import com.example.project1.bean.Trainee;

public interface ITraineeService {
	
	List<Trainee> getAllTrainee();
	Trainee getTraineeByName(String name);
	Trainee getTraineeById(int id);
	Trainee deleteTraineeById(int id);
	Trainee updateTrainee(Trainee trainee);
	Trainee addTrainee(Trainee trainee);

}
