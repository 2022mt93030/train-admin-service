package com.assignment.common;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/*
 * Train Value Object used as shared object between micro-services.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainVO {
	private Long id;
	private String name;
	private String travelDays;
	
	private List<CapacityVO> trainCapacity;
}
