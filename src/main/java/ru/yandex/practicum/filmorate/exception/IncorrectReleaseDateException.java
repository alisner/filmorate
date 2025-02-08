package ru.yandex.practicum.filmorate.exception;

public class IncorrectReleaseDateException extends IllegalFilmArgumentException {

    public IncorrectReleaseDateException() {
        super("Incorrect release date");
    }
}
