package com.example.project1.exception;

public class SkillNotFoundException extends RuntimeException {

	public SkillNotFoundException() {
		super();
	}

	public SkillNotFoundException(String message) {
		super(message);
	}

	public SkillNotFoundException(Throwable cause) {
		super(cause);
	}

}
