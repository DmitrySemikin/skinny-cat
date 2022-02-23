package xyz.dsemikin.skinnycat.guiswing.gui.foodstuff;

import xyz.dsemikin.skinnycat.guiswing.logic.FoodstuffController;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

public class FoodstuffWindow {

    private final FoodstuffController controller;
    private final FoodstuffWindowView view;
    private final FoodstuffTableModel tableModel;

    public FoodstuffWindow(final FoodstuffController foodstuffController) {
        controller = foodstuffController;
        tableModel = new FoodstuffTableModel(foodstuffController);
        view = new FoodstuffWindowView(tableModel);

        view.addButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFoodstuff();
            }
        });

        view.deleteButton().addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFoodstuff();
            }
        });
    }

    private void addFoodstuff() {
        controller.addFoodstuffWithDefaultParameters();
        tableModel.refreshData();
    }

    private void deleteFoodstuff() {
        int minSelectionIndex = view.table().getSelectionModel().getMinSelectionIndex();
        if (minSelectionIndex >= 0) {
            controller.deleteFoodstuff(minSelectionIndex);
            tableModel.refreshData();
        }
    }
}
