package br.com.currencyconverterapi.apicurrencyconverter.dto;

import br.com.currencyconverterapi.apicurrencyconverter.entities.User;

public record UserCreateDTO(
        String name
) {
    public User toUser() {
        User user = new User();
        user.setName(this.name);
        return user;
    }
}
