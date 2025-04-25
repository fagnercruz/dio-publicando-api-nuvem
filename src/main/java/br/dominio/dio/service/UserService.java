package br.dominio.dio.service;

import br.dominio.dio.model.User;

public interface UserService {

    User findById(Long id);
    User create(User user);



}
