package com.spring.AuthenticatedBackend.controllers;

import com.spring.AuthenticatedBackend.Services.AuthenticationService;
import com.spring.AuthenticatedBackend.models.ApplicationUser;
import com.spring.AuthenticatedBackend.models.LoginResponseDTO;
import com.spring.AuthenticatedBackend.models.RegistrationDTO;
import jakarta.servlet.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body){

        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }
    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationDTO body){
        return authenticationService.loginUser(body.getUsername(),body.getPassword());

    }
}
