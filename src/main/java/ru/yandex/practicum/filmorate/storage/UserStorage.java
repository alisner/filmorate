package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.User;

import java.util.List;
import java.util.Set;

public interface UserStorage {
    User save(User user);
    User update(User user);
    User findById(Long userId);
    List<User> findByIdIn(Set<Long> usersId);
    void deleteById(Long userId);
    List<User> findAll();
}
