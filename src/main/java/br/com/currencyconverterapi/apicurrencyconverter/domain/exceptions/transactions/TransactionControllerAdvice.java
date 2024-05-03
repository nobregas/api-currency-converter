package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.transactions;

import br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.MessageExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class TransactionControllerAdvice {

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<MessageExceptionHandler> transactionNotFound(TransactionNotFoundException transactionNotFound) {
        log.info("Transaction Not Found Exception");
        MessageExceptionHandler error = new MessageExceptionHandler(404, transactionNotFound.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

}
