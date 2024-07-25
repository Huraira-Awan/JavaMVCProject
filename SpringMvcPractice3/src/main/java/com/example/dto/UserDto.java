package com.example.dto;

import jakarta.persistence.Column;

public class UserDto {
	
	private String password;
	
	
	private String email;
	
	
	private String fullName;
	
	
	private String department;
	
	
	private String role;


	public UserDto(String password, String email, String fullName, String department, String role) {
		
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.department = department;
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	

	
	
	
}
