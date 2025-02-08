package ru.yandex.practicum.filmorate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.FilmStorage;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmStorage filmStorage;

    public Film createFilm(Film film) {
        return filmStorage.save(film);
    }

    public Film updateFilm(Film film) {
        return filmStorage.update(film);
    }

    public Film getFilmById(Long filmId) {
        return filmStorage.findById(filmId);
    }

    public void deleteFilmById(Long filmId) {
        filmStorage.deleteById(filmId);
    }

    public Map<Long, Film> getAllFilms() {
        return filmStorage.findAll();
    }

    public void addLike(Long filmId, Long userId) {
        Film film = filmStorage.findById(filmId);
        film.getLikes().add(userId);
    }

    public void removeLike(Long filmId, Long userId) {
        Film film = filmStorage.findById(filmId);
        film.getLikes().remove(userId);
    }

    public List<Film> getMostPopularFilmsOrderByLikes(Long count) {
        return getAllFilms().values().stream()
                .sorted(Comparator.comparingLong((Film f) -> f.getLikes().size()).reversed()).limit(count).toList();
    }
}
