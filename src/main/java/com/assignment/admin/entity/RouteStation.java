package com.assignment.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="route_station")
public class RouteStation {

	@EmbeddedId
	private RouteStationPk id;
	
	@Column(name="sequence_no")
	private int sequenceNo;
	
	@ManyToOne
	@MapsId("routeId")
	@JoinColumn(name="route_id")
	private Route route;
	
	@ManyToOne
	@MapsId("stationCode")
	@JoinColumn(name="station_code")
	private Station station;
	
}
