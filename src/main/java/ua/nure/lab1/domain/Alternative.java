package ua.nure.lab1.domain;

public class Alternative extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alternative(String name) {
        this.name = name;
    }

    public Alternative() {
    }

    @Override
    public String toString() {
        return "Alternative{" + "name='" + name + '\'' +
                '}';
    }
}
