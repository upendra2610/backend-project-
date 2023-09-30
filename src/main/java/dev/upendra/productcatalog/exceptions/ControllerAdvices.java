package dev.upendra.productcatalog.exceptions;

import dev.upendra.productcatalog.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ControllerAdvices {


//    @ExceptionHandler(NotFoundExceptions.class)
//    private ResponseEntity<ExceptionDto> notFoundExceptionHandler(NotFoundExceptions notFoundExceptions){
//        return new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundExceptions.getMessage()),
//                HttpStatus.NOT_FOUND
//
//        );
//
//
//    }
//    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
//    private ResponseEntity<ExceptionDto> handleArrayIndexOutOfBound(
//            ArrayIndexOutOfBoundsException notFoundException
//    ) {
//
//        return new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()),
//                HttpStatus.NOT_FOUND
//        );
//    }
}
