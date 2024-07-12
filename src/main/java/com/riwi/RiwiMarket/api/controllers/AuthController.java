package com.riwi.RiwiMarket.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    @PostMapping(path = "/auth/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "Welcome " + username + " to Riwi Market";
    }

    @PostMapping(path = "/auth/register")
    public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "Welcome " + username + " to Riwi Market";
    }
}
