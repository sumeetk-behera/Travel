package com.tyss.tourandtravels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.tourandtravels.constant.Constant;
import com.tyss.tourandtravels.dto.ResponseDto;
import com.tyss.tourandtravels.dto.TourPackageDto;
import com.tyss.tourandtravels.service.TourPackageService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class TourPackageController {

	@Autowired
	private TourPackageService packageService;

	@PostMapping("/savePackage")
	@Operation(summary = "SAVE TOUR PACKAGE FOR A LOCATION API ")
	public ResponseEntity<ResponseDto> savePackage(@RequestBody TourPackageDto packageDto) {
		return ResponseEntity
				.ok(new ResponseDto(false, Constant.PACKAGE_SAVE_SUCCESS, packageService.savePackage(packageDto))); 

	}
}
