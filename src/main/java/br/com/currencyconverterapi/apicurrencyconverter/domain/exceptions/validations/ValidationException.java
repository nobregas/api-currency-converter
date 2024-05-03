package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.validations;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}

