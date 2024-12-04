package com.suryasiddesh.ecom_project_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @GetMapping("/")
    public String hello()
    {
        return "Welcome to project";
    }
}
