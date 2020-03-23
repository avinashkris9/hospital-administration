package org.allsafeclinic.hospitaladministration.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.allsafeclinic.hospitaladministration.model.APIError;

import org.allsafeclinic.hospitaladministration.util.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;



@ControllerAdvice
public class RestExceptionHandler  extends ResponseEntityExceptionHandler {

//    @Override
//	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//
//        APIError apiError=new APIError();
//        apiError.setCode(ErrorCodes.ERROR_CODES.ERR_VALIDATION_FAILURE.name());
//        apiError.setMessage(ErrorCodes.EMPTY_MESSAGE_BODY);
//		return new ResponseEntity<>(apiError,HttpStatus.BAD_REQUEST);
//	}
 


	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {




       //handle Mandatory filed missing/not blank.
       List<String> mandatoryFieldsMissing=
               ex.getBindingResult().getFieldErrors().stream().
               filter(error -> error.getCode().equalsIgnoreCase("NotBlank") || error.getCode().equalsIgnoreCase("NotNull")
               ).map(FieldError::getField).collect(Collectors.toList());
        APIError apiError=new APIError();
       if(mandatoryFieldsMissing.isEmpty())
       {
           System.out.println(" I am here");
           apiError.setMessage((ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage()));
       }
       else
       {
            String errorMessage=mandatoryFieldsMissing.stream().collect(Collectors.joining(",","{","}"));
            errorMessage=ErrorCodes.MANDATORY_MISSING+errorMessage;
            apiError.setMessage(errorMessage);
       }



		apiError.setCode(ErrorCodes.ERROR_CODES.ERR_VALIDATION_FAILURE.name());
        return new ResponseEntity(apiError,HttpStatus.BAD_REQUEST);
    }
    
		
	
    @ExceptionHandler(value={StaffNotFoundException.class})
    public ResponseEntity<APIError> customHandleNotFound(StaffNotFoundException ex) {

    	APIError errors = new APIError();
        errors.setCode(ex.getMessage());
		errors.setMessage(ErrorCodes.USER_NOT_FOUND);
        return new ResponseEntity<>(errors, HttpStatus.NOT_FOUND);

	}


    @ExceptionHandler(value={StaffValidationException.class})
    public ResponseEntity<APIError> validationFailure(StaffValidationException ex) {

    	APIError errors = new APIError();
        errors.setCode(ex.getMessage());
		errors.setMessage(ErrorCodes.INVALID_GENDER);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

	}
	
	   
}