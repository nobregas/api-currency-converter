package br.com.currencyconverterapi.apicurrencyconverter.repositories;

import br.com.currencyconverterapi.apicurrencyconverter.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
