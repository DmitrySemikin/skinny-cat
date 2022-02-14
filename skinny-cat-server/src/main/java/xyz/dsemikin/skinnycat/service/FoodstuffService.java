package xyz.dsemikin.skinnycat.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.jpa.dao.FoodstuffDao;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffDto;
import xyz.dsemikin.skinnycat.jpa.mapper.FoodstuffJpaMapper;

import java.util.List;
import java.util.Optional;

@Stateless
public class FoodstuffService {

    @Inject
    private FoodstuffDao foodstuffDao;

    @Inject
    private FoodstuffJpaMapper mapper;

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
        final FoodstuffDto dto = foodstuffDao.findById(id);
        if (dto == null) {
            return Optional.empty();
        } else {
            return Optional.of(mapper.fromDto(dto));
        }
    }
}
