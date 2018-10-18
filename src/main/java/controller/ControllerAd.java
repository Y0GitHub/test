package controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;

/**
 * @Author: ky
 * @Date: 2018/10/16 23:17
 */
@ControllerAdvice
public class ControllerAd {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    public String a(){
        return "404";
    }
    /*@ExceptionHandler({ConstraintViolationException.class})
    @ResponseBody
    public String b(Error error){

        return "dberror";
    }*/
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String bindException(ConstraintViolationException e) {
        List<String> errorMessages = new ArrayList<String>();
        for (ConstraintViolation violation : e.getConstraintViolations()) {
            errorMessages.add(violation.getMessage());
        }
        return errorMessages.toString();
    }
}
