package br.com.currencyconverterapi.apicurrencyconverter.domain.services;

import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.UserCreateDTO;
import br.com.currencyconverterapi.apicurrencyconverter.domain.dto.UserDto;
import br.com.currencyconverterapi.apicurrencyconverter.domain.entities.User;
import br.com.currencyconverterapi.apicurrencyconverter.domain.exceptions.user.UserNotFoundException;
import br.com.currencyconverterapi.apicurrencyconverter.infra.repositories.UserRepository;
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

    public User getById(long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        return user;
    }

    public void delete(long id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException());
        userRepository.delete(user);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }
}
