package com.assignment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.TrainCapacity;
import com.assignment.admin.entity.TrainCapacityPk;

@Repository
public interface TrainCapacityRepository extends JpaRepository<TrainCapacity, TrainCapacityPk> {

	@Modifying
//	@Query("Update TrainCapacity tc Set tc.totalSeats = :seatCnt Where tc.trainNum=:trainId and tc.trainClass=:bogieType")
	@Query(value = "UPDATE train_capacity SET total_seats = :seatCnt Where train_num=:trainId and travel_class=:bogieType", nativeQuery = true)
	void updateCapacity(@Param("trainId") Long trainId, @Param("bogieType") String bogieType, @Param("seatCnt") Integer seatCnt);
	
//	@Query("Update TrainCapacity tc Set tc.totalSeats = :seatCnt, tc.date= :travelDate Where tc.train.id=:trainId and tc.id.trainClass=:bogieType")
//	TrainCapacity updateCapacityForDate(@Param("trainId") Long trainId, @Param("bogieType") String bogieType, @Param("seatCnt") Integer seatCnt, @Param("travelDate") Date travelDate );
}
