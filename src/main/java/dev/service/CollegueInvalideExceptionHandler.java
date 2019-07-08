package dev.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CollegueInvalideExceptionHandler {
    @ResponseBody
    @ExceptionHandler(CollegueInvalideException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String collegueInvalideHandler(CollegueInvalideException ex) {
      return ex.getMessage();
    }
}
