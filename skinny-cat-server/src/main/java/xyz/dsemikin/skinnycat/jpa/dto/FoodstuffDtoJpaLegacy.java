package xyz.dsemikin.skinnycat.jpa.dto;

import xyz.dsemikin.skinnycat.data.FoodstuffUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "foodstuff")
@Table(name = "foodstuff")
public class FoodstuffDtoJpaLegacy {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private FoodstuffUnit unit;

    public FoodstuffDtoJpaLegacy() {
        id = 0;
        name = "";
        unit = FoodstuffUnit.UNIT;
    }

    public FoodstuffDtoJpaLegacy(long id, String name, FoodstuffUnit unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
