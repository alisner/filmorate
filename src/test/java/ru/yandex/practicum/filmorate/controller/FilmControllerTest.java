package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.exception.IncorrectReleaseDateException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FilmControllerTest {

//    @Test
//    void test1_addFilm_WhenReleaseDateIsValid_ShouldBeAddedSuccessfully() {
//        FilmController fm = new FilmController();
//        Film film = new Film();
//        film.setName("Harry Potter");
//        film.setDuration(73);
//        film.setDescription("description");
//        film.setReleaseDate(LocalDate.of(1895,12,28));
//        film.setId(1);
//
//        Assertions.assertEquals(film, fm.addFilm(film));
//    }
//
//
//    @Test
//    void test2_addFilm_WhenReleaseDateIsNotValid_ShouldThrowException() {
//        FilmController fc = new FilmController();
//        Film film = new Film();
//        film.setName("Harry Potter");
//        film.setDuration(73);
//        film.setDescription("description");
//        film.setReleaseDate(LocalDate.of(1895,12,27));
//        film.setId(1);
//
//        Assertions.assertThrows(IncorrectReleaseDateException.class, () -> {
//            fc.addFilm(film);
//        });
//    }
}