package com.chriscorp.crud.controller;

import com.chriscorp.crud.model.User;
import com.chriscorp.crud.service.userImpl.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable(name = "id") long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable(name = "id")  long id){
        userService.deleteUserById(id);
    }

    @PostMapping
    public User postUser(@RequestBody User user){
        return userService.postUser(user);
    }

    @PutMapping("/{id}")
    public User putUser(@RequestBody User user, @PathVariable(name = "id")  long id) throws Exception {
        return userService.getUserById(id).map(newObj -> {
            newObj.setNombre(user.getNombre());
            newObj.setApellidos(user.getApellidos());
            newObj.setEdad(user.getEdad());
            newObj.setFecha(user.getFecha());
            newObj.setEmail(user.getEmail());
            newObj.setTelefono(user.getTelefono());
            return userService.postUser(newObj);
        }).orElseThrow(() -> new Exception("Product with id " + id + "not found"));
    }

}
