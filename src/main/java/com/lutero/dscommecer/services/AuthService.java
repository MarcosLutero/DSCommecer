package com.lutero.dscommecer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lutero.dscommecer.entities.User;
import com.lutero.dscommecer.services.exceptions.ForbiddenException;



@Service
public class AuthService {
	
	@Autowired
	private UserService userService;
	

	public void validateSelfOrAdmin(long userId) {
		User me = userService.authenticated();
		if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
			throw new ForbiddenException("Access denied");
		}
	}
	
}
