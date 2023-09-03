package com.jsp.airline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.airline.dto.UserDto;
import com.jsp.airline.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> addUser(@RequestBody UserDto dto){
		return ResponseEntity.status(HttpStatus.CREATED).body("user id is: "+userService.userRegistration(dto));
	}
	
	@PostMapping("/login/{uName}/{password}")
	public ResponseEntity<String> userLoginreq(@PathVariable("uName") String username, @PathVariable("password") String password) {
		
		if (userService.userLogin(username, password) != null) {
			return ResponseEntity.status(HttpStatus.FOUND).body("login sucessfull");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("invalid login Credential ");
		}
	}
}
 