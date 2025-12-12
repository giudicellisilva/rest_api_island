package elias.giudicelli.rest_api_island.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

import elias.giudicelli.rest_api_island.service.exception.EmailExistsException;
import elias.giudicelli.rest_api_island.service.exception.UsernameExistsException;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(EmailExistsException.class)
	public ResponseEntity<StandardError> EmailExistsException(EmailExistsException e,
			HttpServletRequest request) {
		int httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();
		StandardError err = new StandardError(httpStatus,
				"Email já cadastrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(err);
	}
	
	@ExceptionHandler(UsernameExistsException.class)
	public ResponseEntity<StandardError> EmailExistsException(UsernameExistsException e,
			HttpServletRequest request) {
		int httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();
		StandardError err = new StandardError(httpStatus,
				"Username já cadastrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(httpStatus).body(err);
	}
}
