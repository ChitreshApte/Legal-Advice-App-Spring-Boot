package com.chitresh.laa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitresh.laa.entities.LegalExpert;
import com.chitresh.laa.entities.User;
import com.chitresh.laa.repository.LegalExpertRepository;
import com.chitresh.laa.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LegalExpertRepository legalExpertRepo;
	
	@GetMapping
	public List<User> getUsers() {
		return userRepository.findAll();	
	}
	
	@GetMapping("/experts")
	public List<LegalExpert> getExperts() {
		return legalExpertRepo.findAll();
//		List<User> allUsers = userRepository.findAll();
//		List<User> experts = new ArrayList<>();
//		for(User u : allUsers)
//			for(Role r : u.getRoles())
//				if(r.getName().equals(ERole.ROLE_LEGALEXPERT)) {
//					experts.add(u);
//					break;
//				}
//		return experts;
	}
	
	//this is for a normal user
//	@GetMapping("/user/{id}")
//	public User getUserDetails(@PathVariable("id") String id) {
//		long identity = Long.parseLong(id);
//		return userRepository.getById(identity);
//	}
//	
//	//this is for a legal expert
//	@GetMapping("/expert/{id}")
//	public LegalExpert getLegalExpertDetails(@PathVariable("id") String id) {
//		long identity = Long.parseLong(id);
//		return legalExpertRepo.getById(identity);
//	}
}
