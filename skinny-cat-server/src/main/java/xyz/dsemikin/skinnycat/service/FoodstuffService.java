package xyz.dsemikin.skinnycat.service;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.jpa.dao.FoodstuffDaoLegacy;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDtoJpaLegacy;
import xyz.dsemikin.skinnycat.jpa.mapper.FoodstuffJpaMapperLegacy;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Stateless
public class FoodstuffService {

    @Inject
    private FoodstuffDaoLegacy foodstuffDao;

    @Inject
    private FoodstuffJpaMapperLegacy mapper;

    public void put(final Foodstuff foodstuff) {
        foodstuffDao.put(mapper.toDto(foodstuff));
    }

    public void delete(final long id) {
        foodstuffDao.delete(id);
    }

    public List<Foodstuff> all() {
        return mapper.fromDtoList(foodstuffDao.all());
    }

    public Optional<Foodstuff> findById(final long id) {
        final FoodstuffDtoJpaLegacy dto = foodstuffDao.findById(id);
        if (dto == null) {
            return Optional.empty();
        } else {
            return Optional.of(mapper.fromDto(dto));
        }
    }
}
