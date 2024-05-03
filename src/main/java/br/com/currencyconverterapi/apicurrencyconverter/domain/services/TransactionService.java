package br.com.currencyconverterapi.apicurrencyconverter.domain.services;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionCreateDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.Transaction;
import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.User;
import br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.transactions.TransactionNotFoundException;
import br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.validations.ValidationException;
import br.com.currencyconverterapi.apicurrencyconverter.infra.repositories.TransactionRepository;
import br.com.currencyconverterapi.apicurrencyconverter.application.utils.currencyconverter.CurrencyConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionService {
    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final CurrencyConverter currencyConverter;

    public TransactionDto create(TransactionCreateDto transactionDto) throws Exception {
        validate(transactionDto);
        log.info("Creating transaction at service");
        log.info("Getting user where id = {}", transactionDto.userId());
        User user = userService.getById(transactionDto.userId());
        LocalDate date = LocalDate.now();
        log.info("Getting conversionRate...");
        double convertionRate = currencyConverter.convertTo(transactionDto);
        double destinationValue = calcDestinationValue(
                transactionDto.originValue(), convertionRate
        );

        Transaction transaction = new Transaction(
                transactionDto, user, date, convertionRate, destinationValue
        );
        log.info("Saving transaction");
        Transaction createdTransaction = transactionRepository.save(transaction);
        log.info("Saved transaction");
        return createdTransaction.toDto();

    }

    public List<TransactionDto> getAll() {
        return transactionRepository.findAll()
                .stream()
                .map(Transaction::toDto)
                .collect(Collectors.toList());
    }

    public List<TransactionDto> getAllByUserId(long userId) {
        return transactionRepository.findAllByUser(userId)
                .stream()
                .map(Transaction::toDto)
                .collect(Collectors.toList());
    }

    public Transaction getById(long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException());
        return transaction;
    }

    private double calcDestinationValue(double value, double rate) {
        return value * rate;
    }

    private void validate(TransactionCreateDto dto) throws Exception {
        log.info("Validating dto");
        if(dto.userId() <= 0) {
            log.info("ValidationException");
            throw new ValidationException("Invalid userId");
        }
        if(dto.originValue() <= 0) {
            log.info("ValidationException");
            throw new ValidationException("Invalid originValue, originValue must be higher than 0");
        }
    }
}
