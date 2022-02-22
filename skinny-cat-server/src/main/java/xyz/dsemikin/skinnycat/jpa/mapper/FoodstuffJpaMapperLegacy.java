package xyz.dsemikin.skinnycat.jpa.mapper;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpaLegacy;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FoodstuffJpaMapperLegacy {
    public FoodstuffDtoJpaLegacy toDto(final Foodstuff foodstuff) {
        return new FoodstuffDtoJpaLegacy(
                foodstuff.id(),
                foodstuff.name(),
                foodstuff.unit()
        );
    }

    public Foodstuff fromDto(final FoodstuffDtoJpaLegacy dto) {
        return new Foodstuff(
                dto.getId(),
                dto.getName(),
                dto.getUnit()
        );
    }

    public List<Foodstuff> fromDtoList(final List<FoodstuffDtoJpaLegacy> dtoList) {
        return dtoList.stream().map(this::fromDto).toList();
    }
}
