package ua.nure.lab1.domain.dto;

import java.io.Serializable;

public class MarkDto implements Serializable {
    private String name;
    private String range;
    private String numMark;
    private String normMark;
    private int criteriaId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getNumMark() {
        return numMark;
    }

    public void setNumMark(String numMark) {
        this.numMark = numMark;
    }

    public String getNormMark() {
        return normMark;
    }

    public void setNormMark(String normMark) {
        this.normMark = normMark;
    }

    public int getCriteriaId() {
        return criteriaId;
    }

    public void setCriteriaId(int criteriaId) {
        this.criteriaId = criteriaId;
    }

    @Override
    public String toString() {
        return "MarkDto{" + "name='" + name + '\'' +
                ", range=" + range +
                ", numMark=" + numMark +
                ", normMark=" + normMark +
                ", criteriaId=" + criteriaId +
                '}';
    }
}
