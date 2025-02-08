package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

public class UserControllerTest {
//
//    private UserController uc;
//
//    @BeforeEach
//    void createUserController() {
//        uc = new UserController();
//    }
//
//    @Test
//    void test1_addUser_WhenUserIsValid_ShouldBeSuccessfully() {
//        User user = new User();
//        user.setId(1);
//        user.setLogin("qwerty");
//        user.setEmail("qwerty@gmail.com");
//        user.setName("Smith");
//        user.setBirthday(LocalDate.of(2000,12,12));
//
//        Assertions.assertEquals(user, uc.addUser(user));
//    }
//
//    @Test
//    void test2_addUser_WhenIdMatch_ShouldBeThrowException() {
//        User user = new User();
//        user.setId(1);
//        user.setLogin("qwerty");
//        user.setEmail("qwerty@gmail.com");
//        user.setName("Smith");
//        user.setBirthday(LocalDate.of(2000,12,12));
//        uc.addUser(user);
//
//        Assertions.assertThrows(ValidationException.class, () -> uc.addUser(user));
//    }
}
