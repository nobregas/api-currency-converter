package br.com.currencyconverterapi.apicurrencyconverter.entities;

import br.com.currencyconverterapi.apicurrencyconverter.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 40)
    private String name;

    public UserDto toDto() {
        return new UserDto(this.getId(), this.getName());
    }
}
