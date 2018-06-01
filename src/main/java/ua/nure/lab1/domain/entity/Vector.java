package ua.nure.lab1.domain.entity;

public class Vector extends Entity {
    private Alternative alternative;
    private Mark mark;

    public Vector(Alternative alternative, Mark mark) {
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

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}
