package com.chriscorp.crud.controller;

import com.chriscorp.crud.exception.ModelNotFoundException;
import com.chriscorp.crud.model.User;
import com.chriscorp.crud.service.userImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable(name = "id") long id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
        } else {
            throw new ModelNotFoundException(id);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable(name = "id")  long id) {
        Optional<User> user = userService.getUserById(id);
        if(user.isPresent()) {
            userService.deleteUserById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ModelNotFoundException(id);
        }
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody User user){
        return new ResponseEntity<>(userService.postUser(user),HttpStatus.OK) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> putUser(@RequestBody User user, @PathVariable(name = "id")  long id) throws Exception {
        return new ResponseEntity<>(userService.getUserById(id).map(newObj -> {
            newObj.setNombre(user.getNombre());
            newObj.setApellidos(user.getApellidos());
            newObj.setEdad(user.getEdad());
            newObj.setFecha(user.getFecha());
            newObj.setEmail(user.getEmail());
            newObj.setTelefono(user.getTelefono());
            return userService.postUser(newObj);
        }).orElseThrow(() -> new Exception("Product with id " + id + "not found")),
        HttpStatus.OK);
    }

}
