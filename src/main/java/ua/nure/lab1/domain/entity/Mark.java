package ua.nure.lab1.domain.entity;

public class Mark extends Entity {
    private String name;
    private int range;
    private int numMark;
    private int normMark;
    private Criterion criterion;

    public Mark(String name, int range, int numMark, int normMark, Criterion criterion) {
        this.name = name;
        this.range = range;
        this.numMark = numMark;
        this.normMark = normMark;
        this.criterion = criterion;
    }

    public Mark() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mark{");
        sb.append("name='").append(name).append('\'');
        sb.append(", range=").append(range);
        sb.append(", numMark=").append(numMark);
        sb.append(", normMark=").append(normMark);
        sb.append(", criterion=").append(criterion);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getNumMark() {
        return numMark;
    }

    public void setNumMark(int numMark) {
        this.numMark = numMark;
    }

    public int getNormMark() {
        return normMark;
    }

    public void setNormMark(int normMark) {
        this.normMark = normMark;
    }

    public Criterion getCriterion() {
        return criterion;
    }

    public void setCriterion(Criterion criterion) {
        this.criterion = criterion;
    }
}
