package com.anirudh.advertiserservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<customError> noResourceFound(Exception ex) {
        customError responseMessage = new customError();
        responseMessage.setMessage("Please check the Request.Something went Wrong.");
        responseMessage.setDetails(ex.getMessage());
        return new ResponseEntity<customError>(responseMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }


    class customError{
        private String message;
        private String details;

        public customError(){

        }

        public customError(String message, String details) {
            this.message = message;
            this.details = details;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }
}
