package ru.fafurin.javacore.second.entity;

import lombok.*;
import ru.fafurin.javacore.second.enums.Gender;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private int age;
    private String phone;
    Gender gender;

}
