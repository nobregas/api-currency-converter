package br.com.currencyconverterapi.apicurrencyconverter.domain.dto;

public record UserDto(
        long id,
        String name
) {

    public String toString() {
        return "{ Id: " + id + ", Name: " + name + " }";
    }
}
