package br.com.currencyconverterapi.apicurrencyconverter.repositories;

import br.com.currencyconverterapi.apicurrencyconverter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
