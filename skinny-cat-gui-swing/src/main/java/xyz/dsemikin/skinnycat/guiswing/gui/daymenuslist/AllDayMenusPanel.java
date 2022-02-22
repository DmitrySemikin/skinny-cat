package xyz.dsemikin.skinnycat.guiswing.gui.daymenuslist;

import xyz.dsemikin.skinnycat.data.DayMenu;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;

import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Optional;

public class AllDayMenusPanel {

    private final DayMenusListView view;
    private final AllDayMenusController controller;
    private final AllDayMenusTableModel allDayMenusTableModel;

    public AllDayMenusPanel(final AllDayMenusController allDayMenusController, final DayMenuDetailsController dayMenuDetailsController) {
        controller = allDayMenusController;
        view = new DayMenusListView(dayMenuDetailsController);
        allDayMenusTableModel = new AllDayMenusTableModel(controller);
        view.dayMenusTable().setModel(allDayMenusTableModel);
        view.dayMenusTable().getSelectionModel().addListSelectionListener(this::onSelectionChanged);

        view.dayMenuDetailsPane().nameText().addActionListener(this::onSelectedDayMenuNameChanged);
        view.dayMenuDetailsPane().descriptionText().addActionListener(this::onSelectedDayMenuDescriptionChanged);
        view.dayMenuDetailsPane().nameText().addFocusListener(new FocusListener() {
            @Override public void focusGained(FocusEvent e) { }
            @Override public void focusLost(FocusEvent e) { onSelectedDayMenuNameChanged(null); }
        });
        view.dayMenuDetailsPane().descriptionText().addFocusListener(new FocusListener() {
            @Override public void focusGained(FocusEvent e) { }
            @Override public void focusLost(FocusEvent e) { onSelectedDayMenuDescriptionChanged(null); }
        });
    }

    public void onSelectionChanged(final ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            final int selectionIndex = view.dayMenusTable().getSelectionModel().getMinSelectionIndex();
            if (selectionIndex >= 0) {
                final Long selectedId = controller.allIds().get(selectionIndex);
                final Optional<DayMenu> maybeDayMenu = controller.get(selectedId);
                view.dayMenuDetailsPane().setDayMenu(maybeDayMenu);
            } else {
                view.dayMenuDetailsPane().setDayMenu(Optional.empty());
            }
        }
    }

    public void onSelectedDayMenuNameChanged(final ActionEvent event) {
        // Note: we cannot setup this callback in DayMenuDetailsPane, because we could not update the AllDayMenus table
        final int selectionIndex = view.dayMenusTable().getSelectionModel().getMinSelectionIndex();
        if (selectionIndex >= 0) {
            final Long selectedId = controller.allIds().get(selectionIndex);
            final String newName = view.dayMenuDetailsPane().nameText().getText();
            controller.setName(selectedId, newName);
            allDayMenusTableModel.refreshData();
            if (selectionIndex < allDayMenusTableModel.getRowCount()) {
                view.dayMenusTable().getSelectionModel().setSelectionInterval(selectionIndex, selectionIndex);
            }
        }
    }

    public void onSelectedDayMenuDescriptionChanged(final ActionEvent event) {
        // Note: we cannot setup this callback in DayMenuDetailsPane, because we could not update the AllDayMenus table
        final int selectionIndex = view.dayMenusTable().getSelectionModel().getMinSelectionIndex();
        if (selectionIndex >= 0) {
            final Long selectedId = controller.allIds().get(selectionIndex);
            final String newDescription = view.dayMenuDetailsPane().descriptionText().getText();
            controller.setDescription(selectedId, newDescription);
            allDayMenusTableModel.refreshData();
            if (selectionIndex < allDayMenusTableModel.getRowCount()) {
                view.dayMenusTable().getSelectionModel().setSelectionInterval(selectionIndex, selectionIndex);
            }
        }
    }

    public JPanel rootPane() {
        return view.rootPane();
    }
}
