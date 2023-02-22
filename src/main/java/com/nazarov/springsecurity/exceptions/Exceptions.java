package com.nazarov.springsecurity.exceptions;

import com.nazarov.springsecurity.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class Exceptions extends Throwable{


    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(AlreadyExistException.class)
    public Response alreadyExistException() {
        return Response.builder().statusCode(HttpStatus.ALREADY_REPORTED.value()).message("Data Already Exist").build();
    }

}
