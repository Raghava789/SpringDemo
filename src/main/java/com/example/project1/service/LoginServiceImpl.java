package com.example.project1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project1.bean.Login;
import com.example.project1.repository.ILoginRepository;
@Service
public class LoginServiceImpl implements ILoginService{
	
	@Autowired
	ILoginRepository loginRepo;

	@Override
	public Login login(Login login) {
		Login dbLogin = loginRepo.getById(login.getEmail());
		if(login.getEmail().equals(dbLogin.getEmail()) && login.getPassword().equals(dbLogin.getPassword())) {
			dbLogin.setLogin(true);
			loginRepo.save(dbLogin);
			return dbLogin;
		}
		return null;
	}

	@Override
	public Login logout(String email) {
		Login login = loginRepo.getById(email);
		login.setLogin(false);
		loginRepo.save(login);
		return login;
		
	}

	@Override
	public void resetPassword(String email) {
		
	}

	@Override
	public Login forgotPassword(String email) {
		return null;
	}
	
	

}
