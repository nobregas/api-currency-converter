package br.com.currencyconverterapi.apicurrencyconverter.infra.repositories;

import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
