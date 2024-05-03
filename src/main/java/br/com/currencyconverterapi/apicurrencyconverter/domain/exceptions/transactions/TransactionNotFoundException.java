package br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.transactions;

public class TransactionNotFoundException extends RuntimeException{
    public TransactionNotFoundException() {
        super("Transaction not found");
    }
}
