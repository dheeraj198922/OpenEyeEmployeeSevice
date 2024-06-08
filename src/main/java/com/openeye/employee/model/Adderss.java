package com.openeye.employee.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Adderss implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4176049149532245842L;
	@Id
	private Long addressId;
	private String houseNo;
	private String streetName;
	private String cityName;
	private String state;
	private String country;
	private String pinCode;

}
