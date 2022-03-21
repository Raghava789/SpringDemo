package com.example.project1.service;

import org.springframework.web.bind.annotation.RestController;

import com.example.project1.bean.Login;

public interface ILoginService {

	Login login(Login login);
	Login logout(String email);
	void resetPassword(String email);
	Login forgotPassword(String email);
}
