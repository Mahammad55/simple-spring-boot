package com.example.simplespringboot.model;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
    String id;
    @NotNull(message = "Name can not be null")
    String name;
    @NotNull(message = "Surname can not be null")
    String surname;
    Integer age;
}
