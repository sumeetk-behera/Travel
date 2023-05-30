package com.tyss.tourandtravels.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookindId;
	private String userName;
	private String locationName;
	private String email;
	private Long mobileNumber;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate tourDate;

	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate createdDate;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;
}
