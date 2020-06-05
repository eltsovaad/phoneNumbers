package com.phonenumbers.service;

import com.phonenumbers.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    User read(int ID,String name);
    void create();
}
