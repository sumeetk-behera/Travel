package com.tyss.tourandtravels.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourPackageDto {

	@NotBlank
	private String packName;

	@NotBlank
	private String includes;

	@NotBlank
	private Integer price;

	@NotBlank
	private String locationName;
}
