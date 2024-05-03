package br.com.currencyconverterapi.apicurrencyconverter.domain.dto;

import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.Currency;

import java.time.LocalDate;


public record TransactionDto (
        long id,
        long userId,
        Currency originCurrency,
        double originValue,
        Currency destinationCurrency,
        double destinationValue,
        double conversionRate,
        LocalDate date
){

}
