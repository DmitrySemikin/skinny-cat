package xyz.dsemikin.skinnycat.guiswing.gui;

import xyz.dsemikin.skinnycat.guiswing.gui.foodstuff.FoodstuffWindow;
import xyz.dsemikin.skinnycat.guiswing.jpa.EntityManagerProviderHibernate;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;
import xyz.dsemikin.skinnycat.guiswing.logic.FoodstuffController;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class SkinnyCatMainWindowViewController {

    private final AllDayMenusController allDayMenusController;
    private final FoodstuffController foodstuffController;
    private final SkinnyCatMainWindowView view;

    public SkinnyCatMainWindowViewController() {

        EntityManagerProviderHibernate entityManagerProvider = new EntityManagerProviderHibernate();

        foodstuffController = new FoodstuffController(entityManagerProvider);
        allDayMenusController = new AllDayMenusController(entityManagerProvider);
        final DayMenuDetailsController dayMenuDetailsController = new DayMenuDetailsController(entityManagerProvider, foodstuffController);

        view = new SkinnyCatMainWindowView(
                allDayMenusController,
                dayMenuDetailsController,
                entityManagerProvider::close);

        // We don't have good place to call close() of entityManagerProviderHybernate

        view.getStartFoodstuffEditorButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFoodstuffEditor();
            }
        });

        view.getAddDayMenuButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDayMenu();
            }
        });

        view.getDeleteDayMenuButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedDayMenu();
            }
        });
    }

    private void startFoodstuffEditor() {
        new FoodstuffWindow(foodstuffController);
    }

    private void addDayMenu() {
        view.getAllDayMenusPanel().addDayMenuWithDefaultParameters();
    }

    private void deleteSelectedDayMenu() {
        view.getAllDayMenusPanel().removeSelectedDayMenu();
    }
}
