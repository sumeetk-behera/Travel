package com.tyss.tourandtravels.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@SuppressWarnings("serial")
@Getter
@AllArgsConstructor
public class AccountNotFoundException extends RuntimeException {

	private final String message;

}
