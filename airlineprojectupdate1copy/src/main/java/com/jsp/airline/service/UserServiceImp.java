package com.jsp.airline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.airline.dto.UserDto;
import com.jsp.airline.entity.User;
import com.jsp.airline.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public int userRegistration(UserDto dto) {
		User user = userRepository.save(User.builder()
				.firstName(dto.getFirstName())
				.lastName(dto.getLastName())
				.mobileNumber(dto.getMobileNumber())
				.gender(dto.getGender())
				.userName(dto.getUserName())
				.password(dto.getPassword())
				.build());
		return user.getUserId();
	}

	@Override
	public User userLogin(String username, String password) {
		User u1 = userRepository.findByUsernameAndPassword(username, password);
		if (u1 != null) {
			return u1;
		} else {
			return null;
		}
		
	}
}
