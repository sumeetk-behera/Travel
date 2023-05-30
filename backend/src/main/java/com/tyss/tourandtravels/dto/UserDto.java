package com.tyss.tourandtravels.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@JsonIgnore
	private Integer id;

	@NotBlank
	private String name;

	@NotBlank
	private String email;

	@NotBlank
	private String address;

	@NotBlank
	private String password;

	@Size(min = 10)
	private Long phoneNumber;
}
