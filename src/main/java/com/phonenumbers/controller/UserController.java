package com.phonenumbers.controller;

import com.phonenumbers.model.User;
import com.phonenumbers.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/company/{id}/users")
    public ResponseEntity<User> read(@PathVariable(name = "id") int ID,@RequestParam String name) {
        final User user = userService.read(ID,name);

        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/create")
    public ResponseEntity<?> create() {
        userService.create();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
