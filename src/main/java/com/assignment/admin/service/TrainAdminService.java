package com.assignment.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.assignment.admin.dto.SearchDto;
import com.assignment.admin.dto.TrainCapacityDto;
import com.assignment.admin.dto.TrainDto;
import com.assignment.admin.entity.Train;
import com.assignment.admin.entity.TrainCapacity;
import com.assignment.admin.entity.TrainCapacityPk;
import com.assignment.admin.repository.RouteRepository;
import com.assignment.admin.repository.RouteStationRepository;
import com.assignment.admin.repository.TrainCapacityRepository;
import com.assignment.admin.repository.TrainRepository;
import com.assignment.admin.repository.TrainStationRepository;

import jakarta.transaction.Transactional;

@Service
public class TrainAdminService {

	@Autowired
	private RouteStationRepository routeStationRepo;
	
	@Autowired
	private TrainStationRepository trainStationRepo;
	
	@Autowired
    private TrainRepository trainRepo;
	
	@Autowired
    private RouteRepository routeRepo;
	
	@Autowired
	private TrainCapacityRepository tCapacityRepo; 
	

	public Object createTrain(TrainDto trainDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	public void addTrainCapacity(Long trainId, TrainCapacityDto tCapDto ) {
		
		TrainCapacityPk pk = new TrainCapacityPk(trainId, tCapDto.getTravelClass());
		TrainCapacity trainCapacity = tCapacityRepo.findById(pk).orElse(null);
		
		TrainCapacity modifiedCapacity = null;
		
		int capacityCnt = trainCapacity.getTotalSeats()+tCapDto.getSeatCount();
		
		if(tCapDto.getTrainDate() != null) {
//			modifiedCapacity = tCapacityRepo.updateCapacityForDate(trainId, tCapDto.getTravelClass(), capacityCnt, tCapDto.getTrainDate());
//			modifiedCapacity = tCapacityRepo.updateCapacityForDate(trainId, tCapDto.getTravelClass(), capacityCnt, tCapDto.getTrainDate());
		} else {
			tCapacityRepo.updateCapacity(trainId, tCapDto.getTravelClass(), capacityCnt);
		}
		
	}
	
	public List<Train> searchTrain(SearchDto searchDto) {
		
		Long routeid = routeStationRepo.findRoutes(searchDto.getStartStation().toUpperCase(), searchDto.getDestination().toUpperCase());

		
		return trainStationRepo.findTrainsForRoute(routeid, searchDto.getStartStation().toUpperCase(), searchDto.getDestination().toUpperCase());
		
	}
	
}
