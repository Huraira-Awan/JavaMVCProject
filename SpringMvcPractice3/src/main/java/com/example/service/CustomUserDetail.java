package com.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.model.User;

public class CustomUserDetail implements UserDetails {
	
	
	private User user;
	
	

	public CustomUserDetail(User user) {
		
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(()-> user.getRole());
	}
	
	public String getName() {
		return user.getName();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}
	
	
	public boolean isAccountNonExpired() {
		return true;
	}
	
	
	public boolean isAccountNonLocked() {
		return true;
	}
	
	
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	
	public boolean isEnabled() {
		return true;
	}

}
