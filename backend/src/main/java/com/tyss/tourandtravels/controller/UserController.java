package com.tyss.tourandtravels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.tourandtravels.constant.Constant;
import com.tyss.tourandtravels.dto.LoginDto;
import com.tyss.tourandtravels.dto.ResponseDto;
import com.tyss.tourandtravels.dto.UserDto;
import com.tyss.tourandtravels.service.UserService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	@Operation(summary = "LOGIN USER API")
	public ResponseEntity<ResponseDto> login(@RequestBody LoginDto loginDto) {
		return ResponseEntity.ok(new ResponseDto(false, Constant.USER_LOGIN_SUCCESS, userService.login(loginDto)));

	}

	@PostMapping("/register")
	@Operation(summary = "REGISTER USER API")
	public ResponseEntity<ResponseDto> register(@RequestBody UserDto userDto) {
		return ResponseEntity.ok(new ResponseDto(false, Constant.USER_SAVE_SUCCESS, userService.register(userDto)));

	}

}
