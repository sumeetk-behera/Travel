package com.tyss.tourandtravels.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@AllArgsConstructor
@Getter
public class LoginFailedException extends RuntimeException {

	private final String message;
}
