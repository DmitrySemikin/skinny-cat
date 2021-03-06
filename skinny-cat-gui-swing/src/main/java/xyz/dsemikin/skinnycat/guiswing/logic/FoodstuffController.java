package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.data.FoodstuffUnit;
import xyz.dsemikin.skinnycat.jpa.dao.EntityManagerProvider;
import xyz.dsemikin.skinnycat.jpa.dao.FoodstuffDao;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpa;
import xyz.dsemikin.skinnycat.jpa.mapper.FoodstuffMapperJpa;

import java.util.List;

public class FoodstuffController {

    private final FoodstuffDao dao;
    private final FoodstuffMapperJpa mapper;

    public FoodstuffController(final EntityManagerProvider entityManagerProvider) {
        mapper = new FoodstuffMapperJpa();
        dao = new FoodstuffDao(entityManagerProvider);
    }

    public void addFoodstuff(final String name, final FoodstuffUnit unit) {
        final long newId = 0L;
        final Foodstuff newFoodstuff = new Foodstuff(newId, name, unit);
        dao.persistNew(mapper.toDto(newFoodstuff));
    }

    public void deleteFoodstuff(final long id) {
        dao.delete(id);
    }

    public List<Long> allIds() {
        // TODO: This is inefficient. Move logic to query.
        return mapper.fromDtoList(dao.all()).stream().map(Foodstuff::id).sorted().toList();
    }

    public Foodstuff get(final long id) {
        // TODO: Check for null
        return mapper.fromDto(dao.findById(id));
    }

    public void setName(final long id, final String newName) {
        final FoodstuffDtoJpa foodstuffDto = dao.findById(id);
        if (foodstuffDto != null) {
            foodstuffDto.setName(newName);
            dao.persistExisting(foodstuffDto);
        }
        // TODO: else
    }

    public void setUnit(final long id, final FoodstuffUnit newUnit) {
        final FoodstuffDtoJpa foodstuffDto = dao.findById(id);
        if (foodstuffDto != null) {
            foodstuffDto.setUnit(newUnit);
            dao.persistExisting(foodstuffDto);
        }
        // TODO: else
    }

    public void addFoodstuffWithDefaultParameters() {
        final FoodstuffDtoJpa foodstuffDto = mapper.toDto(new Foodstuff(0L, "foodstuffName", FoodstuffUnit.GRAM));
        foodstuffDto.setId(null);
        dao.persistNew(foodstuffDto);
    }
}
