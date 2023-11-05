package com.assignment.admin.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.admin.dto.UserDto;
import com.assignment.admin.entity.Role;
import com.assignment.admin.entity.User;
import com.assignment.admin.entity.UserCredentials;
import com.assignment.admin.repository.RoleRepository;
import com.assignment.admin.repository.UserCredentialsRepository;
import com.assignment.admin.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

//@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	

	@Autowired
	UserCredentialsRepository userCredentialsRepository;
	

	@Override
	public UserCredentials findUserByUserName(String userName) {
		return userCredentialsRepository.findUserByUserName(userName);
	}
	

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setEmailId(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        user.setNationality("Indian");
        user.setDateOfBirth(new Date());     
        user.setGender(userDto.getGender());
        Role role = roleRepository.findByRoleName("ROLE_EMPLOYEE");
        if(role == null){
            role = checkRoleExist();
        }
		UserCredentials uc = new UserCredentials();
		uc.setUserName(userDto.getUserName());
		log.info("Password is >>>>>>>>>>>>>>>>>>>>>>>>>>>>"+ userDto.getPassword());
		uc.setPassword(passwordEncoder.encode(userDto.getPassword()));
		uc.setUser(user);
		uc.setRole(role);
		userCredentialsRepository.save(uc);
    }



	/*
	 * @Override public List<UserDto> findAllUsers() { List<User> users =
	 * userRepository.findAll(); return users.stream() .map((user) ->
	 * mapToUserDto(user)) .collect(Collectors.toList()); }
	 * 
	 * private UserDto mapToUserDto(User user){ UserDto userDto = new UserDto();
	 * String[] str = user.getName().split(" "); userDto.setFirstName(str[0]);
	 * userDto.setLastName(str[1]); userDto.setEmail(user.getEmail()); return
	 * userDto; }
	 */
    private Role checkRoleExist(){
        Role role = new Role();
        role.setRoleName("ROLE_EMPLOYEE");
        return roleRepository.save(role);
    }

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findUserByEmailId(email);
	}



}
