/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 9:51 PM
 */

package com.school.demo.api;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.school.demo.model.LoginDetails;
import com.school.demo.model.User;
import com.school.demo.repositories.LoginDetailsRepository;
import com.school.demo.repositories.UserRepository;
import com.school.demo.util.Constants.ERole;
import com.school.demo.security.jwt.JwtUtils;
import com.school.demo.security.payload.request.LoginRequest;
import com.school.demo.security.payload.request.SignupRequest;
import com.school.demo.security.payload.response.JwtResponse;
import com.school.demo.security.payload.response.MessageResponse;
import com.school.demo.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;

	private final LoginDetailsRepository loginDetailsRepository;

	private final UserRepository userRepository;

	private final PasswordEncoder encoder;

	private final JwtUtils jwtUtils;

	public AuthController(AuthenticationManager authenticationManager, LoginDetailsRepository loginDetailsRepository,
						  UserRepository userRepository, PasswordEncoder encoder, JwtUtils jwtUtils) {
		this.authenticationManager = authenticationManager;
		this.loginDetailsRepository = loginDetailsRepository;
		this.userRepository = userRepository;
		this.encoder = encoder;
		this.jwtUtils = jwtUtils;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt,
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (loginDetailsRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (loginDetailsRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		LoginDetails loginDetails = new LoginDetails(signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<Integer> strRoles = signUpRequest.getRole();
		Set<ERole> roles = new HashSet<>();
		if (strRoles == null) {
			roles.add(ERole.ROLE_USER);
		} else {
			roles = strRoles.stream().map(ERole::valueOfLevelCode).collect(Collectors.toSet());
		}
		User userInfo = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(), signUpRequest.getBrthDate());
		userInfo.setLoginDetails(loginDetails);
		loginDetails.setRoles(roles);
		userRepository.save(userInfo);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}