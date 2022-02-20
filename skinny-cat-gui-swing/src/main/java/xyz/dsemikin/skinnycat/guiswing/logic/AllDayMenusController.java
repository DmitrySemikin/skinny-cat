package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skynnycat.data.DayMenu;
import xyz.dsemikin.skynnycat.data.FoodstuffUse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AllDayMenusController {

    final List<DayMenu> allDayMenus;
    final FoodstuffController foodstuffController;

    public AllDayMenusController(final FoodstuffController foodstuffController) {

        this.foodstuffController = foodstuffController;

        allDayMenus = new ArrayList<>();

        final List<FoodstuffUse> firstMenuFoodstuffs = new ArrayList<>();
        firstMenuFoodstuffs.add(new FoodstuffUse(foodstuffController.get(1L), 5.0));
        firstMenuFoodstuffs.add(new FoodstuffUse(foodstuffController.get(2L), 10.0));
        allDayMenus.add(new DayMenu(1L, "Week 1, Day 1", "Breakfast: bla, Supper: bla", firstMenuFoodstuffs));

        final List<FoodstuffUse> secondMenuFoodstuffs = new ArrayList<>();
        secondMenuFoodstuffs.add(new FoodstuffUse(foodstuffController.get(3), 7.0));
        secondMenuFoodstuffs.add(new FoodstuffUse(foodstuffController.get(1), 3.0));
        secondMenuFoodstuffs.add(new FoodstuffUse(foodstuffController.get(2), 1.0));
        allDayMenus.add(new DayMenu(2L, "Week 1, Day 2", "some other description", secondMenuFoodstuffs));
    }

    public List<Long> allIds() {
        return allDayMenus.stream().map(DayMenu::id).toList();
    }

    public Optional<DayMenu> get(final long id) {
        return allDayMenus.stream().filter(dayMenu -> dayMenu.id() == id).findFirst();
    }

    public void setName(final long id, final String name) {
        final Optional<DayMenu> maybeDayMenu = get(id);
        maybeDayMenu.ifPresent(dayMenu -> dayMenu.setName(name));
    }

    public void setDescription(final long id, final String description) {
        final Optional<DayMenu> maybeDayMenu = get(id);
        maybeDayMenu.ifPresent(dayMenu -> dayMenu.setDescription(description));
    }

    public void setFoodstuffs(final long id, final List<FoodstuffUse> newFoodstuffs) {
        final Optional<DayMenu> maybeDayMenu = get(id);
        maybeDayMenu.ifPresent(dayMenu -> dayMenu.setFoodstuffs(newFoodstuffs));
    }
}
