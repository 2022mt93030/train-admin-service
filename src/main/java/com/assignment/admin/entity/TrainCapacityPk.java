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
//@Embeddable
public class TrainCapacityPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5143608437054252859L;

	//@Column(name="train_num")
	private Long trainNum;
	
//	@Column(name="train_class")
	private String trainClass;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrainCapacityPk other = (TrainCapacityPk) obj;
		if (trainClass == null) {
			if (other.trainClass != null)
				return false;
		} else if (!trainClass.equals(other.trainClass))
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
		result = prime * result + ((trainClass == null) ? 0 : trainClass.hashCode());
		result = prime * result + ((trainNum == null) ? 0 : trainNum.hashCode());
		return result;
	}

	
}
