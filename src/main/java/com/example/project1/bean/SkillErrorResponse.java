package com.example.project1.bean;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class SkillErrorResponse {
	private int status;
	private String message;
	private LocalDateTime timeStamp;
}
