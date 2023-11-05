package com.assignment.admin.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TrainStationPK implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 4667080297857963807L;
	
	@Column(name="station_stop,  insertable=false, updatable=false")
	private String stationStop;
	
	@Column(name="train_num,  insertable=false, updatable=false")
	private Long trainNum;
	
	@Column(name="route_no,  insertable=false, updatable=false")
	private Integer routeNum;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainStationPK other = (TrainStationPK) obj;
		if (routeNum == null) {
			if (other.routeNum != null)
				return false;
		} else if (!routeNum.equals(other.routeNum))
			return false;
		if (stationStop == null) {
			if (other.stationStop != null)
				return false;
		} else if (!stationStop.equals(other.stationStop))
			return false;
		if (trainNum == null) {
			if (other.trainNum != null)
				return false;
		} else if (!trainNum.equals(other.trainNum))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((routeNum == null) ? 0 : routeNum.hashCode());
		result = prime * result + ((stationStop == null) ? 0 : stationStop.hashCode());
		result = prime * result + ((trainNum == null) ? 0 : trainNum.hashCode());
		return result;
	}
	
	
//	@EmbeddedId
//	private RouteStationPk routeStation;

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		TrainStationPK other = (TrainStationPK) obj;
//		if (routeStation == null) {
//			if (other.routeStation != null)
//				return false;
//		} else if (!routeStation.equals(other.routeStation))
//			return false;
//		if (trainNum == null) {
//			if (other.trainNum != null)
//				return false;
//		} else if (!trainNum.equals(other.trainNum))
//			return false;
//		return true;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((routeStation == null) ? 0 : routeStation.hashCode());
//		result = prime * result + ((trainNum == null) ? 0 : trainNum.hashCode());
//		return result;
//	}	
}
