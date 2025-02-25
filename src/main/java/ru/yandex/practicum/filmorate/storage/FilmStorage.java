package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.model.Film;

import java.util.List;

public interface FilmStorage {
    Film save(Film film);
    Film update(Film film);
    Film findById(Long filmId);
    void deleteById(Long filmId);
    List<Film> findAll();
}
