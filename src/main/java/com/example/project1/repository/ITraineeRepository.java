package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project1.bean.Trainee;
@Repository
public interface ITraineeRepository extends JpaRepository<Trainee, Integer> {

}
