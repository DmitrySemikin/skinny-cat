package xyz.dsemikin.skinnycat.jpa.mapper;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDto;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class FoodstuffJpaMapper {
    public FoodstuffDto toDto(final Foodstuff foodstuff) {
        return new FoodstuffDto(
                foodstuff.id(),
                foodstuff.name(),
                foodstuff.unit()
        );
    }

    public Foodstuff fromDto(final FoodstuffDto dto) {
        return new Foodstuff(
                dto.getId(),
                dto.getName(),
                dto.getUnit()
        );
    }

    public List<Foodstuff> fromDtoList(final List<FoodstuffDto> dtoList) {
        return dtoList.stream().map(this::fromDto).toList();
    }
}
