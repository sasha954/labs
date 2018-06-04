package ua.nure.lab1.domain.entity;

public class Criteria extends Entity {
    private String name;
    private int range;
    private int weight;
    private Type type;
    private OptimalityType optimType;
    private String units;
    private ScaleType scaleType;

    public Criteria(int id, String name, int range, int weight, Type type, OptimalityType optimType, String units, ScaleType scaleType) {
        setId(id);
        this.name = name;
        this.range = range;
        this.weight = weight;
        this.type = type;
        this.optimType = optimType;
        this.units = units;
        this.scaleType = scaleType;
    }

    public Criteria() {
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public OptimalityType getOptimType() {
        return optimType;
    }

    public void setOptimType(OptimalityType optimType) {
        this.optimType = optimType;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public ScaleType getScaleType() {
        return scaleType;
    }

    public void setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    @Override
    public String toString() {
        return "Criteria{" + "name='" + name + '\'' +
                ", range=" + range +
                ", weight=" + weight +
                ", type=" + type +
                ", optimType=" + optimType +
                ", units='" + units + '\'' +
                ", scaleType=" + scaleType +
                '}';
    }
}
