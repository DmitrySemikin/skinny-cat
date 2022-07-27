package xyz.dsemikin.skinnycat.guiswing.gui2;

import xyz.dsemikin.skinnycat.guiswing.gui2.activedaymenus.ActiveDayMenusView2;
import xyz.dsemikin.skinnycat.guiswing.gui2.alldaymenus.AllDayMenusView2;
import xyz.dsemikin.skinnycat.guiswing.gui2.daymenudetails.DayMenuDetailsView2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class SkinnyCatMainWindowView2 {

    private static final int MARGIN = 5;

    private final JFrame frame;
    private final JButton manageFoodstuffsButton;
    private final JButton fullFoodstuffLisstButton;
    private final AllDayMenusView2 allDayMenusView;
    private final ActiveDayMenusView2 activeDayMenusView;
    private final DayMenuDetailsView2 dayMenuDetailsView;


    public SkinnyCatMainWindowView2(
            final AllDayMenusView2 allDayMenusView,
            final ActiveDayMenusView2 activeDayMenusView,
            final DayMenuDetailsView2 dayMenuDetailsView
    ) {

        frame = new JFrame("Skinny Cat");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());

        manageFoodstuffsButton = new JButton("Manage Foodstuffs...");
        final GridBagConstraints manageFoodstuffsButtonConstraints = new GridBagConstraints();
        manageFoodstuffsButtonConstraints.gridx = 0;
        manageFoodstuffsButtonConstraints.gridy = 0;
        manageFoodstuffsButtonConstraints.weightx = 0.0;
        manageFoodstuffsButtonConstraints.weighty = 0.0;
        manageFoodstuffsButtonConstraints.anchor = GridBagConstraints.WEST;
        manageFoodstuffsButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPane.add(manageFoodstuffsButton, manageFoodstuffsButtonConstraints);

        this.allDayMenusView = allDayMenusView;
        final GridBagConstraints allDayMenusViewConstraints = new GridBagConstraints();
        allDayMenusViewConstraints.gridx = manageFoodstuffsButtonConstraints.gridx;
        allDayMenusViewConstraints.gridy = manageFoodstuffsButtonConstraints.gridy + 1;
        allDayMenusViewConstraints.weightx = 1.0;
        allDayMenusViewConstraints.weighty = 1.0;
        allDayMenusViewConstraints.fill = GridBagConstraints.BOTH;
//        allDayMenusViewConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPane.add(allDayMenusView.contentPanel(), allDayMenusViewConstraints);

        final int rightSideX = allDayMenusViewConstraints.gridx + allDayMenusViewConstraints.gridwidth;

        fullFoodstuffLisstButton = new JButton("Full Foodstuff List...");
        final var fullFoodstuffListButtonConstraints = new GridBagConstraints();
        fullFoodstuffListButtonConstraints.gridx = rightSideX;
        fullFoodstuffListButtonConstraints.gridy = manageFoodstuffsButtonConstraints.gridy;
        fullFoodstuffListButtonConstraints.weightx = 0.0;
        fullFoodstuffListButtonConstraints.weighty = 0.0;
        fullFoodstuffListButtonConstraints.anchor = GridBagConstraints.EAST;
        fullFoodstuffListButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPane.add(fullFoodstuffLisstButton, fullFoodstuffListButtonConstraints);

        this.activeDayMenusView = activeDayMenusView;
        final var activeDayMenusViewConstraints = new GridBagConstraints();
        activeDayMenusViewConstraints.gridx = fullFoodstuffListButtonConstraints.gridx;
        activeDayMenusViewConstraints.gridy = fullFoodstuffListButtonConstraints.gridy + 1;
        activeDayMenusViewConstraints.weightx = 1.0;
        activeDayMenusViewConstraints.weighty = 1.0;
        activeDayMenusViewConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(activeDayMenusView.contentPanel(), activeDayMenusViewConstraints);

        this.dayMenuDetailsView = dayMenuDetailsView;
        final var dayMenuDetailsViewConstraints = new GridBagConstraints();
        dayMenuDetailsViewConstraints.gridx = allDayMenusViewConstraints.gridx;
        dayMenuDetailsViewConstraints.gridy = allDayMenusViewConstraints.gridy + 1;
        dayMenuDetailsViewConstraints.weightx = 1.0;
        dayMenuDetailsViewConstraints.weighty = 1.0;
        dayMenuDetailsViewConstraints.gridwidth = allDayMenusViewConstraints.gridwidth + activeDayMenusViewConstraints.gridwidth;
        dayMenuDetailsViewConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(dayMenuDetailsView.contentPanel(), dayMenuDetailsViewConstraints);

        frame.pack();
    }

    public JFrame frame() {
        return frame;
    }

    public JButton manageFoodstuffsButton() {
        return manageFoodstuffsButton;
    }

    public JButton fullFoodstuffLisstButton() {
        return fullFoodstuffLisstButton;
    }

    public AllDayMenusView2 allDayMenusView() {
        return allDayMenusView;
    }

    public ActiveDayMenusView2 activeDayMenusView() {
        return activeDayMenusView;
    }

    public DayMenuDetailsView2 dayMenuDetailsView() {
        return dayMenuDetailsView;
    }
}
