package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found");
    }
}
