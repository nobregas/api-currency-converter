package br.com.currencyconverterapi.apicurrencyconverter.domain.dto;

import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.Currency;


public record TransactionCreateDto(
        long userId,
        Currency originCurrency,
        double originValue,
        Currency destinationCurrency
) {

}
