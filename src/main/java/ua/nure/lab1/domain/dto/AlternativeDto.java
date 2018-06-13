package ua.nure.lab1.domain.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class AlternativeDto {
    private int alternativeId;
    private String name;
    private String[] marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMarks() {
        return marks;
    }

    public void setMarks(String[] marks) {
        this.marks = marks;
    }

    public int getAlternativeId() {
        return alternativeId;
    }

    public void setAlternativeId(int alternativeId) {
        this.alternativeId = alternativeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("marks", marks)
                .toString();
    }
}
