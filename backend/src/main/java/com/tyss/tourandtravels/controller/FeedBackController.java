package com.tyss.tourandtravels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.tourandtravels.constant.Constant;
import com.tyss.tourandtravels.dto.FeedBackDto;
import com.tyss.tourandtravels.dto.ResponseDto;
import com.tyss.tourandtravels.service.FeedBackService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1")
public class FeedBackController {

	@Autowired
	private FeedBackService feedbackService;

	@PostMapping("/feedback")
	@Operation(summary = "GIVE FEEDBACK API ")
	public ResponseEntity<ResponseDto> saveFeedback(@RequestBody FeedBackDto feedBackDto) {
		return ResponseEntity
				.ok(new ResponseDto(false, Constant.FEEDBACK_SUCCESS, feedbackService.saveFeedback(feedBackDto)));
		
	}
}
