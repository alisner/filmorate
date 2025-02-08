package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        Optional<User> oUser = users.stream().filter(u -> u.getId().equals(user.getId())).findFirst();
        if (oUser.isPresent()) throw new ValidationException("Такой пользователь уже существует");
        users.add(user);
        String s = "Добавлен пользователь: " + user.toString();
        log.info(s);
        return user;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        users.stream().filter(u -> u.getId().equals(user.getId())).forEach(u -> {
            u.setEmail(user.getEmail());
            u.setLogin(user.getLogin());
            u.setName(user.getName());
            u.setBirthday(user.getBirthday());
        });

        User rUser = users.stream().filter(u -> u.getId().equals(user.getId())).findFirst().orElse(null);

        for (User el : users) {
            if (el.getId().equals(user.getId()))
                rUser = el;
        }

        String s = "Обновлен пользователь: " + user.toString();
        log.info(s);
        return rUser;
    }


    @GetMapping
    public List<User> getAllFilms() {
        return users;
    }
}
