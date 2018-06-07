package ua.nure.lab1.domain.entity;

public enum OptimalityType {
    MINIMUM("Минимум"), MAXIMUM("Максимум");

    private String value;

    OptimalityType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

