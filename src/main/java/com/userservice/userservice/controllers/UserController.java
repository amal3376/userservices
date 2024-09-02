package com.userservice.userservice.controllers;

import com.userservice.userservice.dtos.UserDto;
import com.userservice.userservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;

@RestController
@RequestMapping("/users")
public class UserController {


    UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable("id") Long Id){
        return null;
    }
}
