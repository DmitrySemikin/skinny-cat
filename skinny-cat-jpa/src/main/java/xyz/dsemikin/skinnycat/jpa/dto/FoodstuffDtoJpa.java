package xyz.dsemikin.skinnycat.jpa.dto;

import xyz.dsemikin.skinnycat.data.FoodstuffUnit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "foodstuff")
@Table(name = "foodstuff")
public class FoodstuffDtoJpa {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private FoodstuffUnit unit;

    public FoodstuffDtoJpa() {
        id = 0L;
        name = "";
        unit = FoodstuffUnit.UNIT;
    }

    public FoodstuffDtoJpa(Long id, String name, FoodstuffUnit unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
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
