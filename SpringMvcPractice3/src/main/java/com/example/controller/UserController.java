package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.UserDto;
import com.example.dto.UserEditDto;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		
		return "register";
		
	}
	
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {
		model.addAttribute("message", "Registered Successfully");
		userService.save(userDto);
		return "register";
	}
	
	
	@GetMapping("/login")
	public String login() {
		
		
		return "login";
		
	}
	
	@GetMapping("/user-page")
	public String userPage(Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		
		model.addAttribute("user", userDetails);
		
		
		return "user";
		
	} 
	
	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		
		model.addAttribute("user", userDetails);
		
		List<User> users = userServiceImpl.getAllUsersExceptAdmin();
		model.addAttribute("users", users);
		
		return "admin";
		
	}
	
	@GetMapping("/edit")
    public String getEditUserPage(@RequestParam("email") String email, Model model) {
        User user = userServiceImpl.getUserByEmail(email);
        if (user == null) {
            model.addAttribute("message", "User not found");
            return "error";
        }
        UserEditDto userEditDto = new UserEditDto();
        userEditDto.setName(user.getName());
        userEditDto.setDeparment(user.getDepartment());
        model.addAttribute("userEditDto", userEditDto);
        model.addAttribute("email", email); // To keep track of the email for updating the user
        return "edit";
    }
	
	@PostMapping("/edit")
    public String editUser(@RequestParam("email") String email, @ModelAttribute("userEditDto") UserEditDto userEditDto, Model model) {
        User user = userServiceImpl.getUserByEmail(email);
        if (user == null) {
            model.addAttribute("message", "User not found");
            return "error";
        }
        user.setName(userEditDto.getName());
        user.setDepartment(userEditDto.getDeparment());
        userServiceImpl.updateUser(user);
        model.addAttribute("message", "User updated successfully");
        return "redirect:/admin-page";
    }
	
}
