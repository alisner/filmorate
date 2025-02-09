package ru.yandex.practicum.filmorate.storage;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.model.User;

import java.util.*;

@Component
public class InMemoryUserStorage implements UserStorage {

    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public User update(User user) {
        return users.replace(user.getId(), user);
    }

    @Override
    public User findById(Long userId) {
        return users.get(userId);
    }

    public List<User> findByIdIn(Set<Long> usersId) {
        return users.values().stream().filter(user -> usersId.contains(user.getId())).toList();
    }

    @Override
    public void deleteById(Long userId) {
        users.remove(userId);
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().toList();
    }
}
