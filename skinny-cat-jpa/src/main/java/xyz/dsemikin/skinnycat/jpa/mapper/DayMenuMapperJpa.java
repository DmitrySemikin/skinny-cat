package xyz.dsemikin.skinnycat.jpa.mapper;

import xyz.dsemikin.skinnycat.data.DayMenu;
import xyz.dsemikin.skinnycat.jpa.dto.DayMenuDtoJpa;

import java.util.List;

public class DayMenuMapperJpa {

    private final FoodstuffUseMapperJpa foodstuffUseMapper;

    public DayMenuMapperJpa() {
        foodstuffUseMapper = new FoodstuffUseMapperJpa();
    }

    public DayMenuDtoJpa toDto(final DayMenu dayMenu) {
        return new DayMenuDtoJpa(
                dayMenu.id(),
                dayMenu.name(),
                dayMenu.description(),
                foodstuffUseMapper.toDtoList(dayMenu.foodstuffs())
        );
    }

    public DayMenu fromDto(final DayMenuDtoJpa dto) {
        // TODO: Check for nulls
        return new DayMenu(
                dto.getId(),
                dto.getName(),
                dto.getDescription(),
                foodstuffUseMapper.fromDtoList(dto.getFoodstuffList())
        );
    }

    public List<DayMenu> fromDtoList(final List<DayMenuDtoJpa> dtoList) {
        return dtoList.stream().map(this::fromDto).toList();
    }
}
