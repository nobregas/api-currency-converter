package br.com.currencyconverterapi.apicurrencyconverter.infra.repositories;

import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.user.id = ?1")
    List<Transaction> findAllByUser(long userId);
}
