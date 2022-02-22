package xyz.dsemikin.skinnycat.jpa.mapper;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpa;

import java.util.List;

public class FoodstuffMapperJpa {

    public FoodstuffDtoJpa toDto(final Foodstuff foodstuff) {
        return new FoodstuffDtoJpa(
                foodstuff.id(),
                foodstuff.name(),
                foodstuff.unit()
        );
    }

    public Foodstuff fromDto(final FoodstuffDtoJpa dto) {
        return new Foodstuff(
                dto.getId(),
                dto.getName(),
                dto.getUnit()
        );
    }

    public List<Foodstuff> fromDtoList(final List<FoodstuffDtoJpa> dtoList) {
        return dtoList.stream().map(this::fromDto).toList();
    }
}
