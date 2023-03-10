package ru.kata.spring.boot_security.demo.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select user from User user join fetch user.roles where user.username = :username")
    User findByUsername(String username);
}
