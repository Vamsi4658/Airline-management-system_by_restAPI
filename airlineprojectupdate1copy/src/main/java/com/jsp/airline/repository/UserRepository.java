package com.jsp.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.airline.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT user FROM User user WHERE user.userName =:uName AND user.password =:password")
	User findByUsernameAndPassword(@Param("uName") String userName,@Param("password") String password);
}
