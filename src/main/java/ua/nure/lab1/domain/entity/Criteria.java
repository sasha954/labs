package ua.nure.lab1.domain.entity;

public class Criteria extends Entity {
    private String name;
    private int range;
    private int weight;
    private String type;
    private String optimType;
    private String units;
    private String scaleType;

    public Criteria(int id, String name, int range, int weight, String type, String optimType, String units, String scaleType) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOptimType() {
        return optimType;
    }

    public void setOptimType(String optimType) {
        this.optimType = optimType;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getScaleType() {
        return scaleType;
    }

    public void setScaleType(String scaleType) {
        this.scaleType = scaleType;
    }
}
