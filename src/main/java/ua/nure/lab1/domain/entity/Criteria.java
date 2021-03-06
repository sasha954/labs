package ua.nure.lab1.domain.entity;

public class Criteria extends Entity {
    private String name;
    private double range;
    private int weight;
    private Type type;
    private OptimalityType optimType;
    private String units;
    private ScaleType scaleType;

    public Criteria(int id, String name, double range, int weight, Type type, OptimalityType optimType, String units, ScaleType scaleType) {
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

    public Criteria setName(String name) {
        this.name = name;
        return this;
    }

    public double getRange() {
        return range;
    }

    public Criteria setRange(double range) {
        this.range = range;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public Criteria setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public Type getType() {
        return type;
    }

    public Criteria setType(Type type) {
        this.type = type;
        return this;
    }

    public OptimalityType getOptimType() {
        return optimType;
    }

    public Criteria setOptimType(OptimalityType optimType) {
        this.optimType = optimType;
        return this;
    }

    public String getUnits() {
        return units;
    }

    public Criteria setUnits(String units) {
        this.units = units;
        return this;
    }

    public ScaleType getScaleType() {
        return scaleType;
    }

    public Criteria setScaleType(ScaleType scaleType) {
        this.scaleType = scaleType;
        return this;
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
