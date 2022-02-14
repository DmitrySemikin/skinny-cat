package xyz.dsemikin.skinnycat.rest.mapper;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.rest.dto.FoodstuffDtoRest;

public class FoodstuffMapperDtoRest {
    public FoodstuffDtoRest toDto(final Foodstuff foodstuff) {
        return new FoodstuffDtoRest(foodstuff.id(), foodstuff.name(), foodstuff.unit());
    }

    public Foodstuff fromDto(final FoodstuffDtoRest dto) {
        return new Foodstuff(dto.getId(), dto.getName(), dto.getUnit());
    }
}
