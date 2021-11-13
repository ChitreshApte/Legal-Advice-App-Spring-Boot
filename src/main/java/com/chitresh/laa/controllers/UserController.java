package com.chitresh.laa.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitresh.laa.entities.ERole;
import com.chitresh.laa.entities.Role;
import com.chitresh.laa.entities.User;
import com.chitresh.laa.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();	
	}
	
	@GetMapping("/experts")
	public List<User> getExperts() {
		List<User> allUsers = userRepository.findAll();
		List<User> experts = new ArrayList<>();
		for(User u : allUsers)
			for(Role r : u.getRoles())
				if(r.getName().equals(ERole.ROLE_LEGALEXPERT)) {
					experts.add(u);
					break;
				}
		return experts;
	}
}
