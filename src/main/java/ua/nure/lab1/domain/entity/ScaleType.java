package ua.nure.lab1.domain.entity;

public enum  ScaleType {

    NUMBER("Числовой"), INTERVAL("Интервальный"), RANGE("Ранговый"), MARK("Бальный");

    private String value;

    ScaleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
