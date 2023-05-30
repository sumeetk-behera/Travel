package com.tyss.tourandtravels.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackDto {

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NotBlank
	private Integer locationId;

	@NotNull
	private String email;
}
