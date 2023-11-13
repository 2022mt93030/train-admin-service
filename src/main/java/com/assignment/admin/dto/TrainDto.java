package com.assignment.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainDto {
	
	private Long id;
	private String name;
	private String frequency;
	private Long routeNo;
	//add
	//train_capacity
	//train_station
	
	
}
