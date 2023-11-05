package com.assignment.admin.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TrainCapacityPk.class)
@Table(name="train_capacity")
public class TrainCapacity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 944079725741794589L;

//	@EmbeddedId
//	private TrainCapacityPk id;
	
	@Id
	@Column(name="train_num")
	private Long trainNum;
	
	@Id
	@Column(name="travel_class")
	private String trainClass;
	
	@Column(name="total_seats")
	private int totalSeats;
	
	@Column(name="travel_date")
	private Date date;
	
		
	//@ManyToOne
	//@MapsId("trainNum")
	//@JoinColumn(name="train_num")
	//private Train train;
	
//	@MapsId("trainClass")
////	@JoinColumn(name="train_class")
//	private String coachType;
}
