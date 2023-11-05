package com.assignment.admin.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
	public Role findByRoleName(String name);
}
