package com.phonenumbers.controller;

import com.phonenumbers.model.User;
import com.phonenumbers.service.UserService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
Rest controller to catch get queries
* */

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //return a string with a phone number of a user.  For more details see UserServiceImpl class
    @GetMapping(value = "/company/{id}/users")
    public ResponseEntity<String> read(@PathVariable(name = "id") int ID,@RequestParam String name) {
        final String phone = userService.read(ID,name);

        return !phone.equals("Not found")
                ? new ResponseEntity<>(phone, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //creates Users in a List. For more details see UserServiceImpl class
    @GetMapping(value = "/create")
    public ResponseEntity<?> create() {
        userService.create();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
