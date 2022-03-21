package com.example.project1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project1.bean.Login;

public interface ILoginRepository extends JpaRepository<Login, String> {

}
