package ru.yandex.practicum.filmorate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.UserStorage;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStorage userStorage;

    public User createUser(User user) {
        return userStorage.save(user);
    }

    public User updateUser(User user) {
        return userStorage.update(user);
    }

    public User getUserById(Long userId) {
        return userStorage.findById(userId);
    }

    public void deleteUserById(Long userId) {
        userStorage.deleteById(userId);
    }

    public List<User> getAllUsers() {
        return userStorage.findAll();
    }

    public void addFriend(Long currentUserId, Long friendId) {
        getUserById(currentUserId).getFriends().add(friendId);
        getUserById(friendId).getFriends().add(currentUserId);
    }

    public void deleteFriend(Long currentUserId, Long friendId) {
        getUserById(currentUserId).getFriends().remove(friendId);
        getUserById(friendId).getFriends().remove(currentUserId);
    }

    public List<User> getFriendByUserId(Long userId) {
        Set<Long> friendsId = userStorage.findById(userId).getFriends();
        return userStorage.findByIdIn(friendsId);
    }

    public List<User> getMutualFriends(Long currentUserId, Long otherUserId) {
        return getAllUsers().stream()
                .filter(user -> user.getFriends().containsAll(List.of(currentUserId, otherUserId)))
                .toList();
    }

}
