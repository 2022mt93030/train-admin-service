package com.assignment.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findUserByEmailId(String email);

}
