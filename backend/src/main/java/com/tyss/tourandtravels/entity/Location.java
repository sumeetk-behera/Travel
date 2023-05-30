package com.tyss.tourandtravels.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Location.class)
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String locationName;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<TourPackage> packagesList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<Booking> bookingList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
	private List<FeedBack> feedBackList;
}
