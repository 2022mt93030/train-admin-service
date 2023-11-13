package com.assignment.admin.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.assignment.admin.dto.SearchDto;
import com.assignment.admin.dto.TrainCapacityDto;
import com.assignment.admin.dto.TrainDto;
import com.assignment.admin.entity.Route;
import com.assignment.admin.entity.Train;
import com.assignment.admin.entity.TrainCapacity;
import com.assignment.admin.entity.TrainCapacityPk;
import com.assignment.admin.exception.handling.BadRequestException;
import com.assignment.admin.exception.handling.ErrorInfo;
import com.assignment.admin.repository.RouteRepository;
import com.assignment.admin.repository.RouteStationRepository;
import com.assignment.admin.repository.TrainCapacityRepository;
import com.assignment.admin.repository.TrainRepository;
import com.assignment.admin.repository.TrainStationRepository;
import com.assignment.common.CapacityVO;
import com.assignment.common.TrainVO;

import jakarta.transaction.Transactional;

@Service
public class TrainAdminService {

	public static final Integer SLEEPER_SEATS_PER_BOGIE = 30;
	public static final Integer AC3_SEATS_PER_BOGIE = 20;
	public static final Integer AC2_SEATS_PER_BOGIE = 10;
	
	public static final String SLEEPER_CLASS = "SLEEPER";
	public static final String AC2_CLASS = "AC2";
	public static final String AC3_CLASS = "AC3";
	
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
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Value("${train_capacity_update.topic}")
	private String trainCapacityUpdateTopic;

	public Train createTrain(TrainDto trainDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		Train train = modelMapper.map(trainDto, Train.class);
		
		Route route = routeRepo.findById(trainDto.getId()).orElse(null);
		train.setRoute(route);
		return trainRepo.save(train);
	}
	
	public TrainVO getTrain(Long trainNo) {
		Train t= trainRepo.findById(trainNo).orElseThrow(() -> new BadRequestException(new ErrorInfo(HttpStatus.BAD_REQUEST.name(), "Train does not exist.")));
		List<TrainCapacity>tcList = tCapacityRepo.getTrainCapacity(trainNo);
		
		List<CapacityVO> tcVOList= tcList.stream().map(tc->
			new CapacityVO(tc.getTrainClass(), tc.getTotalSeats(), tc.getDate())
		).collect(Collectors.toList());
		
		TrainVO trainVO = new TrainVO(t.getId(), t.getName(), t.getTravelDays(), tcVOList);
		
		return trainVO;
	}
	
	@Transactional
	public void addTrainCapacity(Long trainId, TrainCapacityDto tCapDto) {
		
		TrainCapacityPk pk = new TrainCapacityPk(trainId, tCapDto.getTravelClass());
		TrainCapacity trainCapacity = tCapacityRepo.findById(pk).orElse(null);
		
		TrainCapacity modifiedCapacity = null;
		
		if(trainCapacity != null) {
			int capacityCnt = trainCapacity.getTotalSeats()+tCapDto.getSeatCount();
			modifiedCapacity = tCapacityRepo.updateCapacity(trainId, tCapDto.getTravelClass(), capacityCnt);			 
		} else {
			modifiedCapacity = new TrainCapacity();
			modifiedCapacity.setTrainNum(trainId);
			
			if(tCapDto.getTravelClass()!= null) {
				Integer defaultCapacity = null;
				if(SLEEPER_CLASS.equalsIgnoreCase(tCapDto.getTravelClass())) {
					defaultCapacity = SLEEPER_SEATS_PER_BOGIE;
				} else if(AC2_CLASS.equalsIgnoreCase(tCapDto.getTravelClass())) {
					defaultCapacity = AC2_SEATS_PER_BOGIE;
				} else if(AC3_CLASS.equalsIgnoreCase(tCapDto.getTravelClass())) {
					defaultCapacity = AC3_SEATS_PER_BOGIE;
				}
			
				modifiedCapacity.setTotalSeats(defaultCapacity);
			}
			
			modifiedCapacity.setTrainClass(tCapDto.getTravelClass());
			tCapacityRepo.save(modifiedCapacity);
			
		}
		Optional.ofNullable(modifiedCapacity).ifPresent(c->{
			sendCapacityUpdate(c);
		});
	}
	
	public List<Train> searchTrain(SearchDto searchDto) {
		
		Long routeid = routeStationRepo.findRoutes(searchDto.getStartStation().toUpperCase(), searchDto.getDestination().toUpperCase());
		return trainStationRepo.findTrainsForRoute(routeid, searchDto.getStartStation().toUpperCase(), searchDto.getDestination().toUpperCase());
		
	}
	
	private void sendCapacityUpdate(TrainCapacity tCapacity) {
		kafkaTemplate.send(trainCapacityUpdateTopic, tCapacity);
	}
	
}
