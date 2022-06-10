package xyz.dsemikin.skinnycat.jpa.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity(name = "day_menu")
@Table(name = "day_menu")
public class DayMenuDtoJpa {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;

    // TODO: it is suggested, that it is better, when the "many" side owns the relation
    // Note, that we can only make this end of association mandatory, if we make it navigable from other side.
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name = "day_menu_id")
    private List<FoodstuffUseDtoJpa> foodstuffList;

    public DayMenuDtoJpa() {
    }

    public DayMenuDtoJpa(Long id, String name, String description, List<FoodstuffUseDtoJpa> foodstuffList) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.foodstuffList = foodstuffList;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FoodstuffUseDtoJpa> getFoodstuffList() {
        return foodstuffList;
    }

    public void setFoodstuffList(List<FoodstuffUseDtoJpa> foodstuffList) {
        this.foodstuffList = foodstuffList;
    }
}
