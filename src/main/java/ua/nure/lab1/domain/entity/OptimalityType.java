package ua.nure.lab1.domain.entity;

public enum OptimalityType {
    OPTIMALITY_TYPE1("Тип оптимальности");

    private String value;

    OptimalityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

