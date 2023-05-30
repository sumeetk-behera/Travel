package com.tyss.tourandtravels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.tourandtravels.constant.Constant;
import com.tyss.tourandtravels.dto.LocationDto;
import com.tyss.tourandtravels.dto.ResponseDto;
import com.tyss.tourandtravels.service.LocationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/saveLocation")
	@Operation(summary = "SAVE LOCATION API ")
	public ResponseEntity<ResponseDto> saveLocation(@RequestBody LocationDto locationDto) {
		return ResponseEntity
				.ok(new ResponseDto(false, Constant.LOCATION_SAVE_SUCCESS, locationService.saveLocation(locationDto)));

	}

	@GetMapping("/locations")
	@Operation(summary = "GET ALL LOCATIONS API ")
	public ResponseEntity<ResponseDto> getAllLocation() {
		return ResponseEntity
				.ok(new ResponseDto(false, Constant.LOCATION_GETALL_SUCCESS, locationService.getAllLocation()));

	}

	@GetMapping("/location")
	@Operation(summary = "CHOOSE LOCATION API ")
	public ResponseEntity<ResponseDto> chooseLocation(@RequestParam Integer locationId) {
		return ResponseEntity
				.ok(new ResponseDto(false, Constant.LOCATION_GET_SUCCESS, locationService.chooseLocation(locationId)));

	}

}
