package com.flight.reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flight.reservation.Repository.UserRepository;
import com.flight.reservation.model.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepository.findByEmail(username);
		if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found for email " + username);
        }
		 User user=userOptional.get();
		 return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
	                user.getRoles());
	}

	
}
