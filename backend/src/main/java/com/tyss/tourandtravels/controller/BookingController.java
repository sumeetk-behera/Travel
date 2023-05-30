package com.tyss.tourandtravels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.tourandtravels.constant.Constant;
import com.tyss.tourandtravels.dto.BookingDto;
import com.tyss.tourandtravels.dto.ResponseDto;
import com.tyss.tourandtravels.service.BookingService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@OpenAPIDefinition(info = @Info(title = "TOUR AND TRAVEL", description = "FIND YOUR DESTINATION AND BOOK TOUR", version = "V1"))
@RequestMapping("/api/v1")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping("/bookTour")
	@Operation(summary = "BOOK YOUR TOUR API ")
	public ResponseEntity<ResponseDto> bookTour(@RequestBody BookingDto bookingDto) {
		return ResponseEntity.ok(new ResponseDto(false, Constant.BOOKING_SUCCESS, bookingService.bookTour(bookingDto)));

	}
}
