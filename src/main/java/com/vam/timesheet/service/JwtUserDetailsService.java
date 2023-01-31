package com.vam.timesheet.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vam.timesheet.controller.JwtAuthenticationController;
import com.vam.timesheet.entity.EndUser;
import com.vam.timesheet.repository.UserRepository;

/**
 * @author Parinith.Tiruchanapalli
 *
 */

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	JwtAuthenticationController controller;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		EndUser entity = userRepo.findByemaIdAndPassw0rd(username);

		if (entity != null) {
			return new User(username, controller.getEncodedPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

}