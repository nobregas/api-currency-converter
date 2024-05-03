package br.com.currencyconverterapi.apicurrencyconverter.application.controllers;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionCreateDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.TransactionDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAll() {
        log.info("Getting all transactions");
        return ResponseEntity.ok(transactionService.getAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TransactionDto>> getAllByUserId(@PathVariable("id") Long userId) {
        log.info("Getting all transactions where userId = {}", userId);
        return ResponseEntity.ok(transactionService.getAllByUserId(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDto> getById(@PathVariable Long id) {
        log.info("Getting transaction where id = {}", id);
        return ResponseEntity.ok(transactionService.getById(id).toDto());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid TransactionCreateDto dto) throws Exception {
        log.info("Creating transaction request");
        transactionService.create(dto);
    }

}
