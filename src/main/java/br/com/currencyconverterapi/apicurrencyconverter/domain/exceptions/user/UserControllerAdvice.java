package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.user;

import br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.MessageExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> userNotFound(UserNotFoundException userNotFound) {
        log.info("User Not Found Exception");
        MessageExceptionHandler error = new MessageExceptionHandler(404, userNotFound.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
