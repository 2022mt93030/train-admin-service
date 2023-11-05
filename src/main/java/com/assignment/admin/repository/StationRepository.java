package com.assignment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.Station;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {

}
