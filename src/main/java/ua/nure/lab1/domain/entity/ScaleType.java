package ua.nure.lab1.domain.entity;

public enum  ScaleType {

    SCALE_TYPE1("Тип шкалы1");

    private String value;

    ScaleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
