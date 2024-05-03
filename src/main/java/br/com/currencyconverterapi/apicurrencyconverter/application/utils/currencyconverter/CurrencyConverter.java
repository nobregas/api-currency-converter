package br.com.currencyconverterapi.apicurrencyconverter.application.utils.currencyconverter;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionCreateDto;

public interface CurrencyConverter {
    public double convertTo(TransactionCreateDto transactionDto);
}
