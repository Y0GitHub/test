package controller;

import com.sun.deploy.net.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author: ky
 * @Date: 2018/10/18 22:16
 */
public class EntityError extends ResponseEntityExceptionHandler {
    /*@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        String message="";
        if(result.hasErrors()){
            StringBuffer buffer =new StringBuffer();
            List<ObjectError> errors =result.getAllErrors();
            for(ObjectError error:errors){
                FieldError fieldError= (FieldError) error;
                buffer=buffer.append(fieldError.getDefaultMessage()+",");
            }
            message=buffer.toString().substring(0,buffer.length()-1);
        }

    }*/
}
