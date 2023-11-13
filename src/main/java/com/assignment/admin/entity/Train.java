package com.assignment.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "train")
public class Train {

	@Id	
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="frequency")
	private String travelDays;
	
	@ManyToOne
	@JoinColumn(name="route_id")
	private Route route;
}
