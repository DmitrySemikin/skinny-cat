package xyz.dsemikin.skinnycat.guiswing.logic;

import xyz.dsemikin.skynnycat.data.DayMenu;
import xyz.dsemikin.skynnycat.data.Foodstuff;
import xyz.dsemikin.skynnycat.data.FoodstuffUse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public class DayMenuDetailsController {

    private Optional<DayMenu> maybeDayMenu;
    private final AllDayMenusController allDayMenusController;

    public DayMenuDetailsController(final AllDayMenusController allDayMenusController) {
        this.allDayMenusController = allDayMenusController;
        this.maybeDayMenu = Optional.empty();
    }

    public List<Long> allFoodstuffUsesIds() {
        if (maybeDayMenu.isPresent()) {
            return LongStream.range(0, maybeDayMenu.get().foodstuffs().size()).boxed().toList();
        } else {
            return Collections.emptyList();
        }
    }

    public FoodstuffUse getFoodstuffUse(long id) {
        final DayMenu dayMenu = maybeDayMenu.orElseThrow();
        return dayMenu.foodstuffs().get((int)id);
    }

    public void setFoodstuff(final long id, final Foodstuff newFoodstuff) {
        final DayMenu dayMenu = maybeDayMenu.orElseThrow();
        final FoodstuffUse old = dayMenu.foodstuffs().get((int) id);
        final List<FoodstuffUse> newFoodstuffs = new ArrayList<>(dayMenu.foodstuffs());
        newFoodstuffs.set((int)id, new FoodstuffUse(newFoodstuff, old.quantity()));
        allDayMenusController.setFoodstuffs(dayMenu.id(), newFoodstuffs);
    }

    public void setQuantity(final long id, final double newQuantity) {
        final DayMenu dayMenu = maybeDayMenu.orElseThrow();
        final FoodstuffUse old = dayMenu.foodstuffs().get((int) id);
        final List<FoodstuffUse> newFoodstuffs = new ArrayList<>(dayMenu.foodstuffs());
        newFoodstuffs.set((int)id, new FoodstuffUse(old.foodstuff(), newQuantity));
        allDayMenusController.setFoodstuffs(dayMenu.id(), newFoodstuffs);
    }

    public void setName(final String newName) {
        maybeDayMenu.ifPresent(dayMenu -> allDayMenusController.setName(dayMenu.id(), newName));
    }

    public void setDescription(final String newDescription) {
        maybeDayMenu.ifPresent(dayMenu -> allDayMenusController.setDescription(dayMenu.id(), newDescription));
    }

    /** This method does not fire any "update event" for the gui, so
     * it is assumed, that corresponding GUI-class (e.g. Table-Model or view
     * controller calls this method and then explicitly refreshes GUI.
     */
    public void setDayMenu(final Optional<DayMenu> maybeDayMenu) {
        this.maybeDayMenu = maybeDayMenu;
        // !IMPORTANT: Update of the GUI should be called explicitly after this call
    }
}
