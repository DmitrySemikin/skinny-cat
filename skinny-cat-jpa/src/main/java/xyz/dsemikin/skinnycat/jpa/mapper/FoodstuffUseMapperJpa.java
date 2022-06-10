package xyz.dsemikin.skinnycat.jpa.mapper;

import xyz.dsemikin.skinnycat.data.FoodstuffUse;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffUseDtoJpa;

import java.util.List;

public class FoodstuffUseMapperJpa {

    private final FoodstuffMapperJpa foodstuffMapper;

    public FoodstuffUseMapperJpa() {
        foodstuffMapper = new FoodstuffMapperJpa();
    }

    public FoodstuffUse fromDto(final FoodstuffUseDtoJpa dto) {
        // TODO: Check for nulls
        return new FoodstuffUse(
                dto.getId(),
                foodstuffMapper.fromDto(dto.getFoodstuff()),
                dto.getQuantity()
        );
    }

    public FoodstuffUseDtoJpa toDto(final FoodstuffUse foodstuffUse) {
        return new FoodstuffUseDtoJpa(
                foodstuffUse.id(),
                foodstuffMapper.toDto(foodstuffUse.foodstuff()),
                foodstuffUse.quantity()
        );
    }

    public List<FoodstuffUse> fromDtoList(final List<FoodstuffUseDtoJpa> dtoList) {
        return dtoList.stream().map(this::fromDto).toList();
    }

    public List<FoodstuffUseDtoJpa> toDtoList(final List<FoodstuffUse> foodstuffs) {
        return foodstuffs.stream().map(this::toDto).toList();
    }
}
