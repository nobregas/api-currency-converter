package br.com.currencyconverterapi.apicurrencyconverter.services;

import br.com.currencyconverterapi.apicurrencyconverter.dto.UserCreateDTO;
import br.com.currencyconverterapi.apicurrencyconverter.dto.UserDto;
import br.com.currencyconverterapi.apicurrencyconverter.entities.User;
import br.com.currencyconverterapi.apicurrencyconverter.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto create(UserCreateDTO userDto) {
        User user = userRepository.save(userDto.toUser());
        return user.toDto();
    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    public UserDto getById(long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception());
        return user.toDto();
    }

    public void delete(long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception());
        userRepository.delete(user);
    }
}
