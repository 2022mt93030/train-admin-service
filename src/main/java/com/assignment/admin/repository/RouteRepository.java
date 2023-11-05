package com.assignment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
