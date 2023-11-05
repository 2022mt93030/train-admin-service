package com.assignment.admin.dto;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchDto {

	private String startStation;
	private String destination;
	private Date travelDate;
}
