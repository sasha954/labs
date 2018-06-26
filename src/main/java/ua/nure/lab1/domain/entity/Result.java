package ua.nure.lab1.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Result extends Entity {
    private User user;
    private Alternative alternative;
    private int range;
    private double weight;

    public Result(int id, User user, Alternative alternative, int range, double weight) {
        setId(id);
        this.user = user;
        this.range = range;
        this.weight = weight;
    }


    public Result() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Alternative getAlternative() {
        return alternative;
    }

    public void setAlternative(Alternative alternative) {
        this.alternative = alternative;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("user", user)
                .append("alternative", alternative)
                .append("range", range)
                .append("weight", weight)
                .toString();
    }
}
