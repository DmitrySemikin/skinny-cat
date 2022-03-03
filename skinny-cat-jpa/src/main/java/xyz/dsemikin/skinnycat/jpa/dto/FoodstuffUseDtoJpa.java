package xyz.dsemikin.skinnycat.jpa.dto;

import xyz.dsemikin.skinnycat.data.Foodstuff;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "foodstuff_use")
@Table(name = "foodstuff_use")
public class FoodstuffUseDtoJpa {

    @Id
    @GeneratedValue
    private Long id;
    private Foodstuff foodstuff;
    private Double quantity;

    public FoodstuffUseDtoJpa() {
    }

    public FoodstuffUseDtoJpa(Long id, Foodstuff foodstuff, Double quantity) {
        this.id = id;
        this.foodstuff = foodstuff;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Foodstuff getFoodstuff() {
        return foodstuff;
    }

    public void setFoodstuff(Foodstuff foodstuff) {
        this.foodstuff = foodstuff;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
