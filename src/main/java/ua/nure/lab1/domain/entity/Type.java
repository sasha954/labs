package ua.nure.lab1.domain.entity;

public enum  Type {
    TYPE1("Тип1");

    private String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
