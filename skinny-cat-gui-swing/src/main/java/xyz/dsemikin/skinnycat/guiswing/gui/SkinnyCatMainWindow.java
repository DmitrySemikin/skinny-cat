package xyz.dsemikin.skinnycat.guiswing.gui;

import xyz.dsemikin.skinnycat.guiswing.gui.daymenuslist.DayMenusList;
import xyz.dsemikin.skinnycat.guiswing.gui.foodstuff.FoodstuffWindow;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

public class SkinnyCatMainWindow {

    public SkinnyCatMainWindow() {
        JFrame frame = new JFrame("Skinny Cat");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

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


        final JButton startFoodstuffEditorButton = new JButton("Manage Foodstuffs...");
        startFoodstuffEditorButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFoodstuffEditor();
            }
        });
        final GridBagConstraints startFoodstuffEditorButtonConstraints = new GridBagConstraints();
        startFoodstuffEditorButtonConstraints.gridx = 0;
        startFoodstuffEditorButtonConstraints.gridy = 1;
        startFoodstuffEditorButtonConstraints.weightx = 0.0;
        startFoodstuffEditorButtonConstraints.weighty = 0.0;
        contentPane.add(startFoodstuffEditorButton, startFoodstuffEditorButtonConstraints);


        final JButton addDayMenuToActiveButton = new JButton(">>");
        final GridBagConstraints addDayMenuToActiveButtonConstraints = new GridBagConstraints();
        addDayMenuToActiveButtonConstraints.gridx = 1;
        addDayMenuToActiveButtonConstraints.gridy = 1;
        addDayMenuToActiveButtonConstraints.weightx = 0.0;
        addDayMenuToActiveButtonConstraints.weighty = 0.0;
        contentPane.add(addDayMenuToActiveButton, addDayMenuToActiveButtonConstraints);


        final DayMenusList allDayMenus = new DayMenusList();
        final GridBagConstraints allDayMenusConstraints = new GridBagConstraints();
        allDayMenusConstraints.gridx = 0;
        allDayMenusConstraints.gridy = 2;
        allDayMenusConstraints.gridwidth = 3;
        allDayMenusConstraints.weightx = 1.0;
        allDayMenusConstraints.weighty = 1.0;
        allDayMenusConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(allDayMenus.rootPane(), allDayMenusConstraints);


        final int gridX2ndColumn = 3;

        final JLabel activeDayMenusLabel = new JLabel("Active Day Menus");
        final GridBagConstraints activeDayMenusLabelConstraints = new GridBagConstraints();
        activeDayMenusLabelConstraints.gridx = gridX2ndColumn;
        activeDayMenusLabelConstraints.gridy = 0;
        activeDayMenusLabelConstraints.gridwidth = 5;
        activeDayMenusLabelConstraints.weightx = 1.0;
        activeDayMenusLabelConstraints.weighty = 0.0;
        activeDayMenusLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(activeDayMenusLabel, activeDayMenusLabelConstraints);


        final JButton deleteActiveMenuButton = new JButton("Delete");
        final GridBagConstraints deleteActiveMenuButtonConstraints = new GridBagConstraints();
        deleteActiveMenuButtonConstraints.gridx = gridX2ndColumn;
        deleteActiveMenuButtonConstraints.gridy = 1;
        deleteActiveMenuButtonConstraints.weightx = 0.0;
        deleteActiveMenuButtonConstraints.weighty = 0.0;
        contentPane.add(deleteActiveMenuButton, deleteActiveMenuButtonConstraints);


        final JButton upActiveMenuButton = new JButton("Up");
        final GridBagConstraints upActiveMenuButtonConstraints = new GridBagConstraints();
        upActiveMenuButtonConstraints.gridx = gridX2ndColumn + 1;
        upActiveMenuButtonConstraints.gridy = 1;
        contentPane.add(upActiveMenuButton, upActiveMenuButtonConstraints);


        final JButton downActiveMenuButton = new JButton("Down");
        final GridBagConstraints downActiveMenuButtonConstraints = new GridBagConstraints();
        downActiveMenuButtonConstraints.gridx = gridX2ndColumn + 2;
        downActiveMenuButtonConstraints.gridy = 1;
        contentPane.add(downActiveMenuButton, downActiveMenuButtonConstraints);


        final JButton fullFoodstuffListButton = new JButton("Full Foodstuff List...");
        final GridBagConstraints fullFoodstuffListButtonConstraints = new GridBagConstraints();
        fullFoodstuffListButtonConstraints.gridx = gridX2ndColumn + 3;
        fullFoodstuffListButtonConstraints.gridy = 1;
        contentPane.add(fullFoodstuffListButton, fullFoodstuffListButtonConstraints);


        final DayMenusList activeDayMenus = new DayMenusList();
        final GridBagConstraints activeDayMenusConstraints = new GridBagConstraints();
        activeDayMenusConstraints.gridx = gridX2ndColumn;
        activeDayMenusConstraints.gridy = 2;
        activeDayMenusConstraints.gridwidth = 5;
        activeDayMenusConstraints.weightx = 1.0;
        activeDayMenusConstraints.weighty = 1.0;
        activeDayMenusConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(activeDayMenus.rootPane(), activeDayMenusConstraints);

        final AllDayMenusViewController allDayMenusViewController = new AllDayMenusViewController(allDayMenus);

        frame.pack();
        frame.setVisible(true);
    }

    private void startFoodstuffEditor() {
        new FoodstuffWindow();
    }

}
