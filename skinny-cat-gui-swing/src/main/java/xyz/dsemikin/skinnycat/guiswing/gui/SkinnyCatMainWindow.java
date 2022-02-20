package xyz.dsemikin.skinnycat.guiswing.gui;

import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;
import xyz.dsemikin.skinnycat.guiswing.logic.FoodstuffController;

public class SkinnyCatMainWindow {

    public SkinnyCatMainWindow() {

        final FoodstuffController foodstuffController = new FoodstuffController();
        final AllDayMenusController allDayMenusController = new AllDayMenusController(foodstuffController);
        final DayMenuDetailsController dayMenuDetailsController = new DayMenuDetailsController(allDayMenusController);

        new SkinnyCatMainWindowView(foodstuffController, allDayMenusController, dayMenuDetailsController);
    }
}
