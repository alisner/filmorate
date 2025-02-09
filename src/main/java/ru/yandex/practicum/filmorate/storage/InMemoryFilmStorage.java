package ru.yandex.practicum.filmorate.storage;

import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.*;

@Component
public class InMemoryFilmStorage implements FilmStorage {

    private final Map<Long, Film> films = new HashMap<>();

    @Override
    public Film save(Film film) {
        films.put(film.getId(), film);
        return films.get(film.getId());
    }

    @Override
    public Film update(Film film) {
        return films.replace(film.getId(), film);
    }

    @Override
    public Film findById(Long filmId) {
        return films.get(filmId);
    }

    @Override
    public void deleteById(Long filmId) {
        films.remove(filmId);
    }

    @Override
    public List<Film> findAll() {
        return films.values().stream().toList();
    }


}
