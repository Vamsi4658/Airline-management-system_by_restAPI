package com.jsp.airline.service;

import com.jsp.airline.dto.UserDto;
import com.jsp.airline.entity.User;

public interface UserService {

	int userRegistration(UserDto dto);
	
	User userLogin(String username, String password);
}
