package com.userservice.userservice.controllers;

import com.userservice.userservice.dtos.SignInRequestDto;
import com.userservice.userservice.dtos.SignUpRequestDto;
import com.userservice.userservice.dtos.UserDto;
import com.userservice.userservice.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }
    @GetMapping("/home")
    public String amal(){
        return "amal";
    }
    @PostMapping("/signup")

    public ResponseEntity<UserDto> signUp(@RequestBody SignUpRequestDto request){
        UserDto userDto = authService.signUp(request.getMailId(), request.getPhoneNumber(),request.getPassword(),request.getSecurityQuestion(), request.getSecurityAnswer());
        return  new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/signin")

    public ResponseEntity<UserDto> signIn(@RequestBody SignInRequestDto request){
        UserDto userDto = authService.signIn(request.getMailId(), request.getPassword() );
        return  new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
