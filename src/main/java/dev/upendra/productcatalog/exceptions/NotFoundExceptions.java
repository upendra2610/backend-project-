package dev.upendra.productcatalog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends Exception{


    public NotFoundExceptions(String message){
        super(message);
    }
}
