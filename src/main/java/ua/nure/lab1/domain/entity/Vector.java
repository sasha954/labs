package ua.nure.lab1.domain.entity;

import java.util.List;

public class Vector extends Entity {
    private Alternative alternative;
    private List<Mark> mark;

    public Vector(Alternative alternative, List<Mark> mark) {
        this.alternative = alternative;
        this.mark = mark;
    }

    public Vector() {
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public List<Mark> getMark() {
        return mark;
    }

    public void setMark(List<Mark> mark) {
        this.mark = mark;
    }
}
