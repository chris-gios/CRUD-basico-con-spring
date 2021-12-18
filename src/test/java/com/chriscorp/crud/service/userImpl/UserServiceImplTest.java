package com.chriscorp.crud.service.userImpl;

import com.chriscorp.crud.model.User;
import com.chriscorp.crud.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllUser() {
        when(userRepository.findAll()).thenReturn(Collections.emptyList());
        List<User> miLista = userRepository.findAll();

        verify(userRepository).findAll(); //verifica que se haya usado ese metodo

        assertNotNull(miLista);
    }

    @Test
    void getUserById() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void postUser() {
    }

    @Test
    void putUser() {
    }
}