package com.tyss.tourandtravels.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = User.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String address;
	
	@NotEmpty
	private String password;
	
	@NonNull
	private Long phoneNumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Booking> bookingList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<FeedBack> feedBackList;
}
