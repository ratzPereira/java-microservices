package com.ratz.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.hroauth.entities.User;
import com.ratz.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;

	public User findByEmail(String email) {
		User user = userFeignClient.findUserByEmail(email).getBody();

		if (user == null) {
			logger.error("email not found");
			throw new IllegalArgumentException("Email not found");
		}
		logger.info("email found: " + email);
		return user;

	}
}
