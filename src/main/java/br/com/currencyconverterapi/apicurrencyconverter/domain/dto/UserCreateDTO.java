package br.com.currencyconverterapi.apicurrencyconverter.domain.dto;

import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.User;

public record UserCreateDTO(
        String name
) {
    public User toUser() {
        User user = new User();
        user.setName(this.name);
        return user;
    }
}
