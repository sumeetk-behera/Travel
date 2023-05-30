package com.tyss.tourandtravels.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	@NotBlank
	private String userName;

	@NotBlank
	private String locationName;

	@NotBlank
	private String email;

	@NotBlank
	@Size(min = 10)
	private Long mobileNumber;

	@NotBlank
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate tourDate;

	@NotBlank
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate createdDate;

}
