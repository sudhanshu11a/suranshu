/**
 * 
 */
package com.sudhanshu.work.suranshu.blogs.advice;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import com.sudhanshu.work.suranshu.blogs.exception.ResourceNotFoundException;
import com.sudhanshu.work.suranshu.blogs.exception.ServiceException;
import com.sudhanshu.work.suranshu.blogs.exception.ExceptionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Application exception handler
 * 
 * 400 Bad Request – the request could not be understood. 401 Unauthorized – the
 * request require user authorization. 403 Forbidden – the server refusing to
 * fulfill the request. 404 Not found – the server can not find anything that
 * related to the request ( ex:- try to get user by id that not in the server).
 * 409 Conflict – the request can not be completed due to a resource conflict. (
 * ex:- user id already exist). 417 Expectation Failed - the request con not be
 * completed due to something goes wrong in the application (ex:- unexpected
 * Exception).
 * 
 * @author sudhanshusharma
 *
 */
@RestControllerAdvice
public class BlogsRestExceptionHandler {

	Logger logger = LoggerFactory.getLogger(BlogsRestExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Not Found");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		ExceptionResponse response = new ExceptionResponse();
//		response.setErrorCode("Constraint Violation");
//		response.setErrorMessage(ex.getMessage());
//		return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
//	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<ExceptionResponse> dataBindException(BindException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Constraint Violation");
		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		response.setErrorMessage(errors.toString());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ExceptionResponse> constraintViolationException(ConstraintViolationException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Constraint Violation");
		response.setErrorMessage(ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<ExceptionResponse> serviceException(ServiceException ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Some thing goes wrong with application services");
		logger.error("ServiceException : ", ex);
		response.setErrorMessage("Something goes wrong with application services due to " + ex.getMessage());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.EXPECTATION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> allOtherException(Exception ex) {
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorCode("Some thing goes wrong!");
		logger.error("Exception : ", ex);
		response.setErrorMessage("Something goes worg, please contect the application owner");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.EXPECTATION_FAILED);
	}

}
