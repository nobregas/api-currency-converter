package br.com.currencyconverterapi.apicurrencyconverter.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Currency;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private Currency originCurrency;
    private double originValue;
    @Enumerated(EnumType.STRING)
    private Currency destinationCurrency;
    private double destinationValue;
    private double conversionRate;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}
