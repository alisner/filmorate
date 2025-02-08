package ru.yandex.practicum.filmorate.model;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class User {

    @NotNull
    private Long id;
    @NotNull
    @Email(message = "email should be valid")
    private String email;
    @NotBlank
    @Min(1)
    private String login;
    private String name;
    @Past
    private LocalDate birthday;

    private Set<Long> friends;
}
