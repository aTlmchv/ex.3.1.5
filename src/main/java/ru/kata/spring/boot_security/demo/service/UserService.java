package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public List<User> listUsers();

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);
}
