package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageExceptionHandler {
    private Integer status;
    private String message;
    private LocalDateTime timeStamp;
}
