package br.com.currencyconverterapi.apicurrencyconverter.controllers;

import br.com.currencyconverterapi.apicurrencyconverter.dto.UserCreateDTO;
import br.com.currencyconverterapi.apicurrencyconverter.dto.UserDto;
import br.com.currencyconverterapi.apicurrencyconverter.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody UserCreateDTO userDto) {
        UserDto createdUser = userService.create(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) throws Exception {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
