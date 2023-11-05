package com.assignment.admin.entity;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="train_station")
public class TrainStation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7820269984033434696L;

	@EmbeddedId
	private TrainStationPK id;
	
	@ManyToOne
	@MapsId("trainNum")
	@JoinColumn(name="train_num")
	private Train train;
	
	@OneToOne
	@JoinColumns({
        @JoinColumn(name="route_no", referencedColumnName="route_id"),
        @JoinColumn(name="station_stop", referencedColumnName="station_code")
    })
	private RouteStation routeStation;
	
}
