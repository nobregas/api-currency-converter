package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.validations;

import br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.MessageExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<MessageExceptionHandler> handleHttpMessageNotReadable(HttpMessageNotReadableException err) {
        MessageExceptionHandler message = new MessageExceptionHandler(400, err.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<MessageExceptionHandler> handleValidationException(ValidationException err) {
        MessageExceptionHandler message = new MessageExceptionHandler(400, err.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
