package ua.nure.lab1.domain.dto;

import ua.nure.lab1.domain.entity.Alternative;

public class ChosenAlternative {

    private Alternative alternative;
    private int moreThanQuantity;
    private int lessThanQuantity;
    private int equalsQuantity;

    public ChosenAlternative(Alternative alternative) {
        this.alternative = alternative;
        this.equalsQuantity = 1;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public int getMoreThanQuantity() {
        return moreThanQuantity;
    }

    public void increaseMoreThanQuantity() {
        this.moreThanQuantity++;
    }

    public int getLessThanQuantity() {
        return lessThanQuantity;
    }

    public void increaseLessThanQuantity() {
        this.lessThanQuantity++;
    }

    public int getEqualsQuantity() {
        return equalsQuantity;
    }

    public void increaseEqualsQuantity() {
        this.equalsQuantity++;
    }
}
