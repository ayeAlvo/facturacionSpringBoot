package com.compu.mundo.facturacion.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(CustomException.class)
    public ErrorMessage customException(CustomException exception){
        return new ErrorMessage("CustomExeption", exception.getMessage());
    }
}
