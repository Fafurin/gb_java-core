package ru.fafurin.javacore.second.enums;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String value;

    public String getValue() {
        return value;
    }
    Gender(String value) {
        this.value = value;
    }
}
