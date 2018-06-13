package ua.nure.lab1.domain.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Result extends Entity {
    private User user;
    private Alternative alternative;
    private double range;
    private int weight;

    public Result(int id, User user, Alternative alternative, double range, int weight) {
        setId(id);
        this.user = user;
        this.alternative = alternative;
        this.range = range;
        this.weight = weight;
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

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
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
