package com.openeye.employee.model;

import java.io.Serializable;

import javax.annotation.processing.Generated;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3814066751943605483L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	@NotNull
	private String employeerAssociateId;
	@NotNull
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private boolean active;
}
