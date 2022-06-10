package xyz.dsemikin.skinnycat.guiswing.gui;

import xyz.dsemikin.skinnycat.guiswing.gui.alldaymenus.AllDayMenusPanel;
import xyz.dsemikin.skinnycat.guiswing.gui.daymenuslist.DayMenusListView;
import xyz.dsemikin.skinnycat.guiswing.logic.AllDayMenusController;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class SkinnyCatMainWindowView {

    private final List<Runnable> cleanupActions;
    private final JButton startFoodstuffEditorButton;
    private final JButton addDayMenuButton;
    private final JButton deleteDayMenuButton;
    private final AllDayMenusPanel allDayMenusPanel;
    private final JButton addDayMenuToActiveButton;
    private final JButton deleteActiveMenuButton;
    private final JButton upActiveMenuButton;
    private final JButton downActiveMenuButton;
    private final JButton fullFoodstuffListButton;
    private final DayMenusListView activeDayMenus;

    public SkinnyCatMainWindowView(
            final AllDayMenusController allDayMenusController,
            final DayMenuDetailsController dayMenuDetailsController,
            final Runnable cleanupAction
    ) {
        this.cleanupActions = new ArrayList<>();

        this.cleanupActions.add(cleanupAction);

        JFrame frame = new JFrame("Skinny Cat");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        frame.addWindowListener(new java.awt.event.WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                cleanup();
                super.windowClosing(e);
            }
        });


        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());


        final JLabel dayMenusLabel = new JLabel("All Day Menus");
        final GridBagConstraints dayMenusLabelConstraint = new GridBagConstraints();
        dayMenusLabelConstraint.gridx = 0;
        dayMenusLabelConstraint.gridy = 0;
        dayMenusLabelConstraint.gridwidth = 3;
        dayMenusLabelConstraint.weightx = 1.0;
        dayMenusLabelConstraint.weighty = 0.0;
        dayMenusLabelConstraint.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(dayMenusLabel, dayMenusLabelConstraint);


        startFoodstuffEditorButton = new JButton("Manage Foodstuffs...");
        final GridBagConstraints startFoodstuffEditorButtonConstraints = new GridBagConstraints();
        startFoodstuffEditorButtonConstraints.gridx = 0;
        startFoodstuffEditorButtonConstraints.gridy = 1;
        contentPane.add(startFoodstuffEditorButton, startFoodstuffEditorButtonConstraints);

        addDayMenuButton = new JButton("Add");
        final GridBagConstraints addDayMenuButtonConstraints = new GridBagConstraints();
        addDayMenuButtonConstraints.gridx = 1;
        addDayMenuButtonConstraints.gridy = 1;
        contentPane.add(addDayMenuButton, addDayMenuButtonConstraints);

        deleteDayMenuButton = new JButton("Delete");
        final GridBagConstraints deleteDayMenuButtonConstraints = new GridBagConstraints();
        deleteDayMenuButtonConstraints.gridx = 2;
        deleteDayMenuButtonConstraints.gridy = 1;
        deleteDayMenuButtonConstraints.anchor = GridBagConstraints.WEST;
        contentPane.add(deleteDayMenuButton, deleteDayMenuButtonConstraints);


        allDayMenusPanel = new AllDayMenusPanel(allDayMenusController, dayMenuDetailsController);
        final GridBagConstraints allDayMenusConstraints = new GridBagConstraints();
        allDayMenusConstraints.gridx = 0;
        allDayMenusConstraints.gridy = 2;
        allDayMenusConstraints.gridwidth = 3;
        allDayMenusConstraints.weightx = 1.0;
        allDayMenusConstraints.weighty = 1.0;
        allDayMenusConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(allDayMenusPanel.rootPane(), allDayMenusConstraints);


        final int gridX2ndColumn = 3;

        final JLabel activeDayMenusLabel = new JLabel("Active Day Menus");
        final GridBagConstraints activeDayMenusLabelConstraints = new GridBagConstraints();
        activeDayMenusLabelConstraints.gridx = gridX2ndColumn;
        activeDayMenusLabelConstraints.gridy = 0;
        activeDayMenusLabelConstraints.gridwidth = 5;
        activeDayMenusLabelConstraints.weightx = 1.0;
        activeDayMenusLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(activeDayMenusLabel, activeDayMenusLabelConstraints);

        addDayMenuToActiveButton = new JButton(">>");
        final GridBagConstraints addDayMenuToActiveButtonConstraints = new GridBagConstraints();
        addDayMenuToActiveButtonConstraints.gridx = gridX2ndColumn;
        addDayMenuToActiveButtonConstraints.gridy = 1;
        contentPane.add(addDayMenuToActiveButton, addDayMenuToActiveButtonConstraints);


        deleteActiveMenuButton = new JButton("Delete");
        final GridBagConstraints deleteActiveMenuButtonConstraints = new GridBagConstraints();
        deleteActiveMenuButtonConstraints.gridx = gridX2ndColumn + 1;
        deleteActiveMenuButtonConstraints.gridy = 1;
        contentPane.add(deleteActiveMenuButton, deleteActiveMenuButtonConstraints);


        upActiveMenuButton = new JButton("Up");
        final GridBagConstraints upActiveMenuButtonConstraints = new GridBagConstraints();
        upActiveMenuButtonConstraints.gridx = gridX2ndColumn + 2;
        upActiveMenuButtonConstraints.gridy = 1;
        contentPane.add(upActiveMenuButton, upActiveMenuButtonConstraints);


        downActiveMenuButton = new JButton("Down");
        final GridBagConstraints downActiveMenuButtonConstraints = new GridBagConstraints();
        downActiveMenuButtonConstraints.gridx = gridX2ndColumn + 3;
        downActiveMenuButtonConstraints.gridy = 1;
        contentPane.add(downActiveMenuButton, downActiveMenuButtonConstraints);


        fullFoodstuffListButton = new JButton("Full Foodstuff List...");
        final GridBagConstraints fullFoodstuffListButtonConstraints = new GridBagConstraints();
        fullFoodstuffListButtonConstraints.gridx = gridX2ndColumn + 4;
        fullFoodstuffListButtonConstraints.gridy = 1;
        fullFoodstuffListButtonConstraints.anchor = GridBagConstraints.WEST;
        contentPane.add(fullFoodstuffListButton, fullFoodstuffListButtonConstraints);


        activeDayMenus = new DayMenusListView(dayMenuDetailsController);
        final GridBagConstraints activeDayMenusConstraints = new GridBagConstraints();
        activeDayMenusConstraints.gridx = gridX2ndColumn;
        activeDayMenusConstraints.gridy = 2;
        activeDayMenusConstraints.gridwidth = 5;
        activeDayMenusConstraints.weightx = 1.0;
        activeDayMenusConstraints.weighty = 1.0;
        activeDayMenusConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(activeDayMenus.rootPane(), activeDayMenusConstraints);

        frame.pack();
        frame.setVisible(true);
    }

    private void cleanup() {
        for (Runnable cleanupAction : cleanupActions) {
            cleanupAction.run();
        }
    }

    public JButton getStartFoodstuffEditorButton() {
        return startFoodstuffEditorButton;
    }

    public JButton getAddDayMenuButton() {
        return addDayMenuButton;
    }

    public JButton getDeleteDayMenuButton() {
        return deleteDayMenuButton;
    }

    public AllDayMenusPanel getAllDayMenusPanel() {
        return allDayMenusPanel;
    }

    public JButton getAddDayMenuToActiveButton() {
        return addDayMenuToActiveButton;
    }

    public JButton getDeleteActiveMenuButton() {
        return deleteActiveMenuButton;
    }

    public JButton getUpActiveMenuButton() {
        return upActiveMenuButton;
    }

    public JButton getDownActiveMenuButton() {
        return downActiveMenuButton;
    }

    public JButton getFullFoodstuffListButton() {
        return fullFoodstuffListButton;
    }

    public DayMenusListView getActiveDayMenus() {
        return activeDayMenus;
    }
}
