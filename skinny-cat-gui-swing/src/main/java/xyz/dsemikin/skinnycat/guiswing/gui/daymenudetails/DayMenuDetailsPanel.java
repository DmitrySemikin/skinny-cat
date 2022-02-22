package xyz.dsemikin.skinnycat.guiswing.gui.daymenudetails;

import xyz.dsemikin.skinnycat.data.DayMenu;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Optional;

/** View controller of DayMenuDetailsPanel GUI element. Responsible for logic of the GUI element. */
public class DayMenuDetailsPanel {

    private final DayMenuDetailsPanelView view;
    private final DayMenuDetailsController controller;
    private final DayFoodstuffTableModel tableModel;

    public DayMenuDetailsPanel(final DayMenuDetailsController dayMenuDetailsController) {
        view = new DayMenuDetailsPanelView();
        controller = dayMenuDetailsController;
        tableModel = new DayFoodstuffTableModel(controller);
        view.getFoodstuffTable().setModel(tableModel);

    }

    public void setDayMenu(final Optional<DayMenu> maybeDayMenu) {
        if (maybeDayMenu.isPresent()) {
            final DayMenu dayMenu = maybeDayMenu.get();
            view.nameText().setText(dayMenu.name());
            view.descriptionText().setText(dayMenu.description());
        } else {
            view.nameText().setText("");
            view.descriptionText().setText("");
        }
        controller.setDayMenu(maybeDayMenu);
        tableModel.refreshData();
    }

    public JPanel rootPanel() {
        return view.rootPanel();
    }

    public JTextField nameText() {
        return view.nameText();
    }

    public JTextField descriptionText() {
        return view.descriptionText();
    }
}
