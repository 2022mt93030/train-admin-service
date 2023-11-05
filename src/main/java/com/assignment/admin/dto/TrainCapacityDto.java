package com.assignment.admin.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainCapacityDto {

	private String travelClass;
	private int seatCount;
	private Date trainDate;
}
