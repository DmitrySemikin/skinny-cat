package xyz.dsemikin.skinnycat.rest.mapper;

import xyz.dsemikin.skinnycat.rest.dto.FoodstuffDtoRest;
import xyz.dsemikin.skynnycat.data.Foodstuff;

import java.util.List;

public class FoodstuffMapperDtoRest {

    public FoodstuffDtoRest toDto(final Foodstuff foodstuff) {
        return new FoodstuffDtoRest(foodstuff.id(), foodstuff.name(), foodstuff.unit());
    }

    public List<FoodstuffDtoRest> toDtoList(final List<Foodstuff> foodstuffList) {
        return foodstuffList.stream().map(this::toDto).toList();
    }

    public Foodstuff fromDto(final FoodstuffDtoRest dto) {
        return new Foodstuff(dto.getId(), dto.getName(), dto.getUnit());
    }
}
