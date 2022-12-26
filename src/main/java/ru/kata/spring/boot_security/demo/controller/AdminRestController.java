package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.MyUserDetailService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AdminRestController {

    private final MyUserDetailService myUserDetailService;
    private UserServiceImpl userServiceImpl;

    @Autowired
    public AdminRestController(MyUserDetailService myUserDetailService, UserServiceImpl userServiceImpl) {
        this.myUserDetailService = myUserDetailService;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUserList() {
        List<User> list = userServiceImpl.listUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userServiceImpl.getUserById(id));
    }

    @PostMapping("/admin/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.ok(userServiceImpl.addUser(user));
    }

    @PatchMapping("/admin/users")
    public void editUser(@RequestBody User user) {
         userServiceImpl.updateUser(user);
    }

    @DeleteMapping("/admin/users/{id}")
    public void removeUser(@PathVariable int id) {
        userServiceImpl.removeUser(id);
    }

    @GetMapping ("/user")
    public ResponseEntity<User> getUser(Authentication authentication) {
        return ResponseEntity.ok((User) authentication.getPrincipal());
    }
}
