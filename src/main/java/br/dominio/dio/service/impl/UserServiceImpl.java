package br.dominio.dio.service.impl;

import br.dominio.dio.model.User;
import br.dominio.dio.repository.UserRepository;
import br.dominio.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(userRepository.existsByAccountNumber(user.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account Number already exists for another user");
        }
        if(userRepository.existsByCardNumber(user.getCard().getNumber())){
            throw new IllegalArgumentException("This Card Number already exists for another user");
        }
        return userRepository.save(user);
    }
}
