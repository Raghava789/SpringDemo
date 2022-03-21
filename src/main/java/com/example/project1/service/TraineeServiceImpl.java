package com.example.project1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.bean.Trainee;
import com.example.project1.repository.ITraineeRepository;

@Service
public class TraineeServiceImpl implements ITraineeService{
	
	@Autowired
	ITraineeRepository traRepo;

	@Override
	public List<Trainee> getAllTrainee() {
		return traRepo.findAll();
	}

	@Override
	public Trainee getTraineeByName(String name) {
		return null;
	}

	@Override
	public Trainee getTraineeById(int id) {
		return traRepo.getById(id);
	}

	@Override
	public Trainee deleteTraineeById(int id) {
		return null;
	}

	@Override
	public Trainee updateTrainee(Trainee trainee) {
		return null;
	}

	@Override
	public Trainee addTrainee(Trainee trainee) {
		return traRepo.save(trainee);
	}

}
