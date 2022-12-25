package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.MyUserDetailService;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserRESTController {
    private final MyUserDetailService myUserDetailService;

    @Autowired
    public UserRESTController(MyUserDetailService myUserDetailService) {
        this.myUserDetailService = myUserDetailService;
    }

    @GetMapping()
    public User getUser(Principal principal) {
        return (User) ((UsernamePasswordAuthenticationToken)principal).getPrincipal();
    }
}
