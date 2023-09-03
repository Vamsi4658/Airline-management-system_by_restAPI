package com.jsp.airline.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder 
@ToString
public class UserDto {

	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String gender;
	private String userName;
	private String password;
}
