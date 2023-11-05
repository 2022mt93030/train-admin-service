package com.assignment.admin.service;

import com.assignment.admin.dto.UserDto;
import com.assignment.admin.entity.User;
import com.assignment.admin.entity.UserCredentials;

public interface UserService {
	public void saveUser(UserDto user);
	public UserCredentials findUserByUserName(String userName);
	public User findUserByEmail(String email);

}
