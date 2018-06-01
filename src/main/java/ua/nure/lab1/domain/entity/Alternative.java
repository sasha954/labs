package ua.nure.lab1.domain.entity;

public class Alternative extends Entity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Alternative(int id, String name) {
        this.name = name;
        super.setId(id);
    }

    public Alternative() {
    }

    @Override
    public String toString() {
        return "Alternative{" + "name='" + name + '\'' +
                '}';
    }
}
