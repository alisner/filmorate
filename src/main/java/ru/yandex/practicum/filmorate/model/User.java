package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class User {

    @NotNull(message = "Поле id обязательное")
    private Long id;
    @NotNull(message = "поле email обязательное")
    @Email(message = "email should be valid")
    private String email;
    @NotBlank(message = "Поле login не может быть пустым или отсутствовать")
    @Size(min = 1, message = "Поле логин должно быть не меньше 1")
    private String login;
    private String name;
    @Past(message = "Не корректная дата рождения")
    private LocalDate birthday;

    private Set<Long> friends;
}
