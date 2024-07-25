package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_tbl" , uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@Column
	private String password;
	
	@Column
	private String email;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column
	private String department;
	
	@Column
	private String role;
	
	
	
	
	public User() {}
	
	

	public User(String password, String email, String fullName, String department, String role) {
		
		this.password = password;
		this.email = email;
		this.fullName = fullName;
		this.department = department;
		this.role = role;
	}
	

	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}




	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
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

	public String getName() {
		return fullName;
	}

	public void setName(String fullName) {
		this.fullName = fullName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
	
}
