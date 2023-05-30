package com.tyss.tourandtravels.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tyss.tourandtravels.exception.AccountNotFoundException;
import com.tyss.tourandtravels.exception.LocationFoundException;
import com.tyss.tourandtravels.exception.LocationsNotFoundException;
import com.tyss.tourandtravels.exception.LoginFailedException;
import com.tyss.tourandtravels.exception.PackageAlreadyPresentException;
import com.tyss.tourandtravels.exception.PackageNotAvailableException;
import com.tyss.tourandtravels.exception.SomethingWentWrongException;
import com.tyss.tourandtravels.exception.UserFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<?> noAccount(AccountNotFoundException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());

	}

	@ExceptionHandler(LocationFoundException.class)
	public ResponseEntity<?> location(LocationFoundException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());

	}

	@ExceptionHandler(LocationsNotFoundException.class)
	public ResponseEntity<?> noLocation(LocationsNotFoundException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());

	}

	@ExceptionHandler(LoginFailedException.class)
	public ResponseEntity<?> loginFailed(LoginFailedException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());

	}

	@ExceptionHandler(PackageAlreadyPresentException.class)
	public ResponseEntity<?> tourPackage(PackageAlreadyPresentException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());

	}

	@ExceptionHandler(PackageNotAvailableException.class)
	public ResponseEntity<?> noPackage(PackageNotAvailableException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}

	@ExceptionHandler(SomethingWentWrongException.class)
	public ResponseEntity<?> wrong(SomethingWentWrongException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}

	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> userPresent(UserFoundException exception) {
		return ResponseEntity.badRequest().body(exception.getMessage());
	}

}
