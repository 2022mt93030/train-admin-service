package com.assignment.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.Train;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {

//	@Query("Select t from train t where t.route.id=:routNum")
//	List<Train> findTrainsForRoute(@Param("routeNum") int routeNum);
	
}
