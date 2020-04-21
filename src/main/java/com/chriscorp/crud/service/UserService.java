package com.chriscorp.crud.service;

import com.chriscorp.crud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();

    Optional<User> getUserById(long id);

    void deleteUserById(long id);

    User postUser(User user);

    User putUser(User user);

}
