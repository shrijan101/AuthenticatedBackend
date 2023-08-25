package com.spring.AuthenticatedBackend.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @GetMapping("/")
    public String helloAdminController(){
        return "Admin level access";
    }
}
