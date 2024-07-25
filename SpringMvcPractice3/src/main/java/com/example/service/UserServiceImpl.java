package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.dto.UserEditDto;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User save(UserDto userDto) {
	 User user = new User(passwordEncoder.encode(userDto.getPassword()), 
			 userDto.getEmail(), 
			 userDto.getFullName(), 
			 userDto.getDepartment(), 
			 userDto.getRole()
			 );
		
		return userRepository.save(user);
	}
	
	public List<User> getAllUsersExceptAdmin() {
        return userRepository.findAllExceptAdmin();
    }
	
	 public User getUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }
	 
	 
	 public User updateUser(User user) {
	        return userRepository.save(user);
	    }
	 
	 
	 
	
	

}
