package com.example.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.bean.Employee;
import com.example.project1.bean.Skill;
import com.example.project1.exception.EmployeeNotFoundException;
import com.example.project1.exception.SkillNotFoundException;
import com.example.project1.repository.ISkillRepository;

@Service
public class SkillServiceImpl implements ISkillService{
	
	@Autowired
	ISkillRepository skillRepo;

	@Override
	public List<Skill> getAllSkills() {
		return skillRepo.findAll();
	}

	@Override
	public Skill getSkillById(int skillId) {
		Optional<Skill> opt = skillRepo.findById(skillId);
		if(!opt.isPresent()) {
			throw new SkillNotFoundException("Skill not found with the given id: "+skillId);
		}
		return opt.get();
	}

	@Override
	public Skill addSkill(Skill skill) {
		// TODO Auto-generated method stub
		return skillRepo.save(skill);
	}

	@Override
	public Skill deleteSkillById(int skillId) {
		Optional<Skill> opt = skillRepo.findById(skillId);
		if(!opt.isPresent()) {
			throw new SkillNotFoundException("Skill not found with the given id: "+skillId);
		}
		skillRepo.deleteById(skillId);
		return opt.get();
	}

	@Override
	public Skill updateSkill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
