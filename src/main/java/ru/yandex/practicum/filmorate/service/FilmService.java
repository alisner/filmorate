package ru.yandex.practicum.filmorate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.exception.FilmNotFoundException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.FilmStorage;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmStorage filmStorage;

    public Film createFilm(Film film) {
        return filmStorage.save(film);
    }

    public Film updateFilm(Film film) {
        getFilmById(film.getId());
        return filmStorage.update(film);
    }

    public Film getFilmById(Long filmId) {
        Film film = filmStorage.findById(filmId);
        if (film == null)
            throw new FilmNotFoundException("Фильм с id " + filmId + " не найден");
        return filmStorage.findById(filmId);
    }

    public void deleteFilmById(Long filmId) {
        getFilmById(filmId);
        filmStorage.deleteById(filmId);
    }

    public List<Film> getAllFilms() {
        return filmStorage.findAll();
    }

    public void addLike(Long filmId, Long userId) {
        getFilmById(filmId);
        Film film = filmStorage.findById(filmId);
        film.getLikes().add(userId);
    }

    public void removeLike(Long filmId, Long userId) {
        getFilmById(filmId);
        Film film = filmStorage.findById(filmId);
        film.getLikes().remove(userId);
    }

    public List<Film> getMostPopularFilmsOrderByLikes(Long count) {
        return getAllFilms().stream()
                .sorted(Comparator.comparingLong((Film f) -> f.getLikes().size()).reversed()).limit(count).toList();
    }
}
