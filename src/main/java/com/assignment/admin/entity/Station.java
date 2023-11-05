package com.assignment.admin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "station")
public class Station {

	@Id
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
}
