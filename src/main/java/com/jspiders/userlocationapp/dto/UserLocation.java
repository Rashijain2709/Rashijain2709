package com.jspiders.userlocationapp.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_location")
public class UserLocation {

	@Id
	private String name;
	private String latitude;
	private String longitude;
	private boolean excluded;

}
