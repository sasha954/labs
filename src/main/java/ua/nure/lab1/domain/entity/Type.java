package ua.nure.lab1.domain.entity;

public enum Type {
    QUANTITY("Количественный"), QUALITY("Качественный");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    }
