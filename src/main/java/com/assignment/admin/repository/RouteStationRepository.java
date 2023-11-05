package com.assignment.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.admin.entity.RouteStation;
import com.assignment.admin.entity.RouteStationPk;

@Repository
public interface RouteStationRepository extends JpaRepository<RouteStation, RouteStationPk>{

//	@Query("SELECT e FROM Employee e WHERE e.department.id = :deptId")
//	List<Employee> findByDept(@Param("deptId") int deptId);
//	
//	@Query("SELECT e FROM Employee e WHERE e.id in (SELECT DISTINCT p.supervisor.id FROM Employee p WHERE p.department.id = :deptId)")
//	List<Employee> findSupervisorsByDept(@Param("deptId") int deptId);
	
//	select route_id from trainadmindb.route_station where station_code="PUN" and route_id = (
//			select route_id from trainadmindb.route_station where station_code="DD");
	
//	@Query("SELECT e.route FROM RouteStation e WHERE e.station.code=:start and e.route.id = "
//			+ "(SELECT e.route.id FROM RouteStation e WHERE e.station.code=:dest)")
	@Query(value="select route_id from route_station where station_code=:start and route_id = (\r\n"
			+ "select route_id from route_station where station_code=:dest)", nativeQuery = true)
	Long findRoutes(@Param("start") String start, @Param("dest") String dest);
}
