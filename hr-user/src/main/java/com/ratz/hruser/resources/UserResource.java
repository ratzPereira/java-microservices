package com.ratz.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.hruser.entities.User;
import com.ratz.hruser.repositories.UserRepository;

@RefreshScope
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository repository;

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findUserById(@PathVariable Long id) {
		User user = repository.findById(id).get();
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value = "/search")
	public ResponseEntity<User> findUserByEmail(@RequestParam String email) {
		User user = repository.findByEmail(email);
		return ResponseEntity.ok().body(user);
	}

}
