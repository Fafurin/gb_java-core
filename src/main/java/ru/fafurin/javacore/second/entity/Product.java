package ru.fafurin.javacore.second.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private String title;
    private int price;
}
