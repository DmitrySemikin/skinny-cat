package xyz.dsemikin.skinnycat.guiswing.gui;

import xyz.dsemikin.skinnycat.guiswing.jpa.EntityManagerProviderHibernate;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;
import xyz.dsemikin.skinnycat.guiswing.logic.FoodstuffController;

public class SkinnyCatMainWindow {



    public SkinnyCatMainWindow() {

        EntityManagerProviderHibernate entityManagerProvider = new EntityManagerProviderHibernate();

        final FoodstuffController foodstuffController = new FoodstuffController(entityManagerProvider);
        final AllDayMenusController allDayMenusController = new AllDayMenusController(foodstuffController);
        final DayMenuDetailsController dayMenuDetailsController = new DayMenuDetailsController(allDayMenusController);

        new SkinnyCatMainWindowView(
                foodstuffController,
                allDayMenusController,
                dayMenuDetailsController,
                entityManagerProvider::close);

        // We don't have good place to call close() of entityManagerProviderHybernate
    }
}
