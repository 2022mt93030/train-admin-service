package com.assignment.admin.controller;

import static com.assignment.admin.service.Constant.APP_CONTEXT_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.admin.dto.SearchDto;
import com.assignment.admin.dto.TrainCapacityDto;
import com.assignment.admin.dto.TrainDto;
import com.assignment.admin.service.TrainAdminService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping(APP_CONTEXT_PATH)
@RestController
public class AdminController {

	@Autowired
	private TrainAdminService adminService;
	
	@ApiOperation(value = "Booking: create reservation for the passenger", notes = "Booking: create reservation for the passenger")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "reservation ticket is created successfully"),
			@ApiResponse(code = 400, message = "Bad Request") })
	@PostMapping(value = "/train", produces = "application/json")
	public ResponseEntity<?> createTrain(@RequestBody final TrainDto trainDto) {
		return new ResponseEntity<>(this.adminService.createTrain(trainDto),
				HttpStatus.CREATED);
	}
	
		
	@PutMapping(value = "/train/{trainNum}", produces = "application/json")
	public ResponseEntity<?> addAdditionalCapacityToTrain(@PathVariable final Long trainNum, @RequestBody final TrainCapacityDto tcd) {
		this.adminService.addTrainCapacity(trainNum, tcd);
		return new ResponseEntity<>("Train coaches increased",
				HttpStatus.OK);
	}
	
	@GetMapping(value = "/train/search", produces = "application/json")
	public ResponseEntity<?> searchTrain(@RequestBody final SearchDto searchDto) {

		return new ResponseEntity<>(this.adminService.searchTrain(searchDto), HttpStatus.OK);
		
	}
	
	//kafka listener
	public void updateNonConfirmedTicket() {
	
		//1. when someone cancel confirm ticket
		//2. when passenger cancel unconfirm ticket
		//3. when admin receive extra quota to train
	}
	
	
	
}
