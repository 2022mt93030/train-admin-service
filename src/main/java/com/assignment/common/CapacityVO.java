package com.assignment.common;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CapacityVO {
	private String travelClass;
	private Integer seatsCount;
	private Date travelDate;
}
