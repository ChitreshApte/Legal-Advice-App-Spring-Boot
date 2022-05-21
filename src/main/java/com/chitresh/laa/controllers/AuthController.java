package com.chitresh.laa.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitresh.laa.entities.ERole;
import com.chitresh.laa.entities.LegalExpert;
import com.chitresh.laa.entities.Role;
import com.chitresh.laa.entities.User;
import com.chitresh.laa.payload.request.LoginRequest;
import com.chitresh.laa.payload.request.SignupRequestExpert;
import com.chitresh.laa.payload.request.SignupRequestUser;
import com.chitresh.laa.payload.response.JwtResponse;
import com.chitresh.laa.payload.response.MessageResponse;
import com.chitresh.laa.repository.LegalExpertRepository;
import com.chitresh.laa.repository.RoleRepository;
import com.chitresh.laa.repository.UserRepository;
import com.chitresh.laa.security.jwt.JwtUtils;
import com.chitresh.laa.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	LegalExpertRepository legalExpertRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
	
	@PostMapping("/signupUser")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequestUser signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account, this is a normal user
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getPhoneNumber(),
							 signUpRequest.getProfession(),
							 signUpRequest.getDescription());

		//we know that this is a normal user
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	@PostMapping("/signupExpert")
	public ResponseEntity<?> registerExpert(@Valid @RequestBody SignupRequestExpert signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account, this is a legal expert
		// the details stored in this object are common to all the users
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getPhoneNumber(),
							 signUpRequest.getProfession(),
							 signUpRequest.getDescription());

		//we know that this is a legal expert
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_LEGALEXPERT)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		
		user.setRoles(roles);
		userRepository.save(user);
		
		//getting the id of the currently added legal expert
		Optional<User> currentUser = userRepository.findByUsername(signUpRequest.getUsername());
		Long currentUserId = currentUser.get().getId();
		
		//Creating the Legal Expert
		LegalExpert expert = new LegalExpert(currentUserId,
				signUpRequest.getUsername(),
				signUpRequest.getProfession(),
				signUpRequest.getDomainSpecialization(),
				signUpRequest.getCity(),
				signUpRequest.getState(),
				signUpRequest.getCountry(),
				signUpRequest.getExperience(),
				signUpRequest.getClientProblems(),
				signUpRequest.getTargetClients(),
				signUpRequest.getTagline(),
				signUpRequest.getKeywords()
				);
		
		//saving the legal expert in the database
		legalExpertRepo.save(expert);

		return ResponseEntity.ok(new MessageResponse("Legal Expert registered successfully!"));
	}
	
	//this will not be exposed in the front end 
	@PostMapping("/signupOnlyForAdmin")
	public ResponseEntity<?> registerAdmin(@Valid @RequestBody SignupRequestUser signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account, this is a ADMIN
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.getPhoneNumber(),
							 signUpRequest.getProfession(),
							 signUpRequest.getDescription());

		//we know that this is a admin
		Set<Role> roles = new HashSet<>();
		Role userRole = roleRepository.findByName(ERole.ROLE_ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Hello newly registered admin!"));
	}
	
}