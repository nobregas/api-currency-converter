package br.com.currencyconverterapi.apicurrencyconverter.application.controllers;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.UserCreateDTO;
import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.UserDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.services.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader {
    private final UserService userService;

    @PostConstruct
    void loadData() {
        log.info("Loading data...");
        userService.deleteAll();

        UserCreateDTO userA = new UserCreateDTO("Alpha");
        UserCreateDTO userB = new UserCreateDTO("Beta");
        userService.create(userA);
        userService.create(userB);

        List<UserDto> users = userService.getAll();
        users.forEach(user -> log.info(user.toString()));
        log.info("Loading data complete.");

    }
}
