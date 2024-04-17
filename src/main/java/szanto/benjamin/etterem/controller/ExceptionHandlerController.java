package szanto.benjamin.etterem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import szanto.benjamin.etterem.exception.MenuNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Menu not found")
    @ExceptionHandler(MenuNotFoundException.class)
    private  void  userNotFoundExceptionHandler(){}
}
