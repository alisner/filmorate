package ru.yandex.practicum.filmorate.exception;

public class IllegalUserArgumentException extends ValidationException {
    public IllegalUserArgumentException(String message) {
        super(message);
    }
}
