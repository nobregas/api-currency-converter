package br.com.currencyconverterapi.apicurrencyconverter.domain.entities;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionCreateDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


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
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;

    public Transaction(TransactionCreateDto transactionDto, User user, LocalDate date, double convertionRate,double destinationValue ) {
        this.originCurrency = transactionDto.originCurrency();
        this.originValue = transactionDto.originValue();
        this.destinationCurrency = transactionDto.destinationCurrency();
        this.destinationValue = destinationValue;
        this.conversionRate = convertionRate;
        this.date = date;
        this.user = user;
    }

    public TransactionDto toDto() {
        return new TransactionDto(
                this.getId(),
                this.getUser().getId(),
                this.getOriginCurrency(),
                this.getOriginValue(),
                this.getDestinationCurrency(),
                this.getDestinationValue(),
                this.getConversionRate(),
                this.getDate()
        );
    }
}
