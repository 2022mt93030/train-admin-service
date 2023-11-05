package com.assignment.admin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.Train;
import com.assignment.admin.entity.TrainStation;
import com.assignment.admin.entity.TrainStationPK;

@Repository
public interface TrainStationRepository extends JpaRepository<TrainStation, TrainStationPK> {

//	Select train_num from trainadmindb.train_station where route_no=1111 and station_stop="SHN" and train_num in
//			(select train_num from trainadmindb.train_station where route_no=1111 and station_stop="CST"); 
	
	
//	@Query(" Select ts.train from TrainStation ts1 "
//			+ "Where ts1.routeStation.id.routeNum=:routeNum and ts1.routeStation.station.code=:startStation "
//			+ "and ts1.train.id in  "
//			+ "(Select ts.Train.id from TrainStation ts "
//			+ "where ts.routeStation.id.routeNum=:routeNum and ts.routeStation.station.code=:destination)")
//	List<Train> findTrainsForRoute(@Param("routeNum") int routeNum, @Param("startStation") String startStation, @Param("destination") String destination);
	
	@Query(" Select ts1.train from TrainStation ts1 "
			+ "Where ts1.routeStation.route.id=:routeNum and ts1.routeStation.station.code=:startStation "
			+ "and ts1.train.id in  "
			+ "(Select ts.train.id from TrainStation ts "
			+ "where ts.routeStation.route.id=:routeNum and ts.routeStation.station.code=:destination)")
	List<Train> findTrainsForRoute(@Param("routeNum") Long routeNum, @Param("startStation") String startStation, @Param("destination") String destination);
}
