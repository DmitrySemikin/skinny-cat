package xyz.dsemikin.skinnycat.rest.dto;

import data.FoodstuffUnit;

public class FoodstuffDtoRest {

    private Long id;
    private String name;
    private FoodstuffUnit unit;

    public FoodstuffDtoRest(Long id, String name, FoodstuffUnit unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public FoodstuffDtoRest() {
        id = 0L;
        name = "";
        unit = FoodstuffUnit.UNIT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodstuffUnit getUnit() {
        return unit;
    }

    public void setUnit(FoodstuffUnit unit) {
        this.unit = unit;
    }
}
