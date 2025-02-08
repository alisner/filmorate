package ru.yandex.practicum.filmorate.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.IncorrectReleaseDateException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/films")
public class FilmController {

    private final List<Film> films = new ArrayList<>();

    @PostMapping
    public Film addFilm(@Valid @RequestBody Film film) {
        Optional<Film> oFilm = films.stream().filter(f -> f.getId().equals(film.getId())).findFirst();
        if (oFilm.isPresent()) throw new ValidationException("Фильм с таким id уже есть в базе");

        try {
            if (film.getReleaseDate().isBefore(LocalDate.of(1895,12,28)))
                throw new IncorrectReleaseDateException();
        } catch (ValidationException e) {
            log.error("Ошибка {}", e.getMessage());
            throw e;
        }
        films.add(film);
        String s = "Добавлен фильм: " + film.toString();
        log.info(s);
        return film;
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) {
        try {
            if (film.getReleaseDate().isBefore(LocalDate.of(1895,12,28)))
                throw new IncorrectReleaseDateException();
        } catch (ValidationException e) {
            log.error("Ошибка {}", e.getMessage());
            throw e;
        }

        films.stream().filter(f -> f.getId().equals(film.getId())).forEach(f -> {
            f.setDescription(film.getDescription());
            f.setName(film.getName());
            f.setDuration(film.getDuration());
            f.setReleaseDate(film.getReleaseDate());
        });

        Optional<Film> rFilm = films.stream().filter(f -> f.getId().equals(film.getId())).findFirst();
        if (rFilm.isEmpty()) {
            throw new ValidationException("Film not found");
        }
        String s = "Обновлен фильм: " + film.toString();
        log.info(s);
        return rFilm.get();
    }


    @GetMapping
    public List<Film> getAllFilms() {
        return films;
    }

}
