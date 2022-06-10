package xyz.dsemikin.skinnycat.jpa.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "foodstuff_use")
@Table(name = "foodstuff_use")
public class FoodstuffUseDtoJpa {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "foodstuff_id")
    private FoodstuffDtoJpa foodstuff;
    private Double quantity;

    @SuppressWarnings("unused")
    public FoodstuffUseDtoJpa() {
        // Required by JPA
    }

    public FoodstuffUseDtoJpa(Long id, FoodstuffDtoJpa foodstuff, Double quantity) {
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

    public FoodstuffDtoJpa getFoodstuff() {
        return foodstuff;
    }

    public void setFoodstuff(FoodstuffDtoJpa foodstuff) {
        this.foodstuff = foodstuff;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
