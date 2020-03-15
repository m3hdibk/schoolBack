/*
 * Copyright (c) 3/15/20, 10:36 PM. Mehdi 3/15/20, 10:23 PM
 */

package com.school.demo.security.services;

import com.school.demo.model.LoginDetails;
import com.school.demo.repositories.LoginDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final LoginDetailsRepository loginDetailsRepository;

	public UserDetailsServiceImpl(LoginDetailsRepository loginDetailsRepository) {
		this.loginDetailsRepository = loginDetailsRepository;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginDetails user = loginDetailsRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}