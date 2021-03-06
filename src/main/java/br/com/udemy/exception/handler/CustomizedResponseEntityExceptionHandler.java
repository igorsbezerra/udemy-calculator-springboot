package br.com.udemy.exception.handler;

import br.com.udemy.exception.ExceptionResponse;
import br.com.udemy.exception.UnsuportedMathOperationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

    @ExceptionHandler(UnsuportedMathOperationException.class)
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(UnsuportedMathOperationException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
