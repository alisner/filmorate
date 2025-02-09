package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class Film {

    @NotNull(message = "Поле id обязательное")
    private Long id;

    @NotNull(message = "Поле name обязательное")
    private String name;
    @Size(max = 200, message = "Поле description нн должно превышать 200 символом")
    private String description;
    @NotNull(message = "Поле releaseDate обязательное")
    private LocalDate releaseDate;
    @Positive(message = "Поле duration не может быть отрицательным")
    private int duration; // в минутах

    private Set<Long> likes;
}
