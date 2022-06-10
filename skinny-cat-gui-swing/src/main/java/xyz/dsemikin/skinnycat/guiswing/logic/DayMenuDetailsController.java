package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skinnycat.data.DayMenu;
import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.data.FoodstuffUse;
import xyz.dsemikin.skinnycat.jpa.dao.EntityManagerProvider;
import xyz.dsemikin.skinnycat.jpa.dao.FoodstuffUseDao;
import xyz.dsemikin.skinnycat.jpa.dto.FoodstuffUseDtoJpa;
import xyz.dsemikin.skinnycat.jpa.mapper.FoodstuffMapperJpa;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public class DayMenuDetailsController {

    private final FoodstuffUseDao foodstuffUseDao;
    private final FoodstuffMapperJpa foodstuffMapper;
    private final FoodstuffController foodstuffController;

    private Optional<DayMenu> maybeDayMenu;

    public DayMenuDetailsController(
            final EntityManagerProvider entityManagerProvider,
            final FoodstuffController foodstuffController
    ) {
        this.foodstuffUseDao = new FoodstuffUseDao(entityManagerProvider);
        this.foodstuffMapper = new FoodstuffMapperJpa();
        this.maybeDayMenu = Optional.empty();
        this.foodstuffController = foodstuffController;
    }

    public List<Long> allFoodstuffUsesIds() {
        if (maybeDayMenu.isPresent()) {
            return LongStream.range(0, maybeDayMenu.get().foodstuffs().size()).boxed().toList();
        } else {
            return Collections.emptyList();
        }
    }

    public FoodstuffUse getFoodstuffUse(long foodstuffUseId) {
        final DayMenu dayMenu = maybeDayMenu.orElseThrow();
        return dayMenu.foodstuffs().get((int)foodstuffUseId);
    }

    public void setFoodstuff(final long foodstuffUseId, final Foodstuff newFoodstuff) {
        final FoodstuffUseDtoJpa maybeFoodstuffUse = foodstuffUseDao.findById(foodstuffUseId);
        if (maybeFoodstuffUse != null) {
            // TODO: Does it below works? Does it not matter, that we created DTO and not fetched it from the DB?
            maybeFoodstuffUse.setFoodstuff(foodstuffMapper.toDto(newFoodstuff));
            foodstuffUseDao.persistExisting(maybeFoodstuffUse);
        }
    }

    public void setQuantity(final long foodstuffUseId, final double newQuantity) {
        final FoodstuffUseDtoJpa maybeFoodstuffUse = foodstuffUseDao.findById(foodstuffUseId);
        if (maybeFoodstuffUse != null) {
            // TODO: Does it below works? Does it not matter, that we created DTO and not fetched it from the DB?
            maybeFoodstuffUse.setQuantity(newQuantity);
            foodstuffUseDao.persistExisting(maybeFoodstuffUse);
        }
    }

    /** This method does not fire any "update event" for the gui, so
     * it is assumed, that corresponding GUI-class (e.g. Table-Model or view
     * controller calls this method and then explicitly refreshes GUI.
     */
    public void setDayMenu(final Optional<DayMenu> maybeDayMenu) {
        this.maybeDayMenu = maybeDayMenu;
        // !IMPORTANT: Update of the GUI should be called explicitly after this call
    }

    public void addFoodstuffUseWithDefaultParameters() {
        List<Long> foodstuffIds = foodstuffController.allIds();
        if (!foodstuffIds.isEmpty()){
            final Foodstuff foodstuff = foodstuffController.get(foodstuffIds.get(0));
            final FoodstuffUseDtoJpa foodstuffUseDto = new FoodstuffUseDtoJpa(null, foodstuffMapper.toDto(foodstuff), 0.0);
            foodstuffUseDao.persistNew(foodstuffUseDto);
        }
    }
}
