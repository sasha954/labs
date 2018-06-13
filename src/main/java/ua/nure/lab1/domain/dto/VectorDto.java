package ua.nure.lab1.domain.dto;

import ua.nure.lab1.domain.entity.Mark;

import java.util.List;

public class VectorDto {
    private int alternativeId;
    private String[] markId;

    public int getAlternativeId() {
        return alternativeId;
    }

    public void setAlternativeId(int alternativeId) {
        this.alternativeId = alternativeId;
    }

    public String[] getMarkId() {
        return markId;
    }

    public void setMarkId(String[] markId) {
        this.markId = markId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("VectorDto{");
        sb.append("alternativeId=").append(alternativeId);
        sb.append(", marksId=").append(markId);
        sb.append('}');
        return sb.toString();
    }
}
