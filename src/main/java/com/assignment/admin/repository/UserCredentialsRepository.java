package com.assignment.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.User;
import com.assignment.admin.entity.UserCredentials;
@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Long>{
	public UserCredentials findUserByUserName(String username);

}
