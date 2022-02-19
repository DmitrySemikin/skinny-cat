package xyz.dsemikin.skinnycat.guiswing.gui.daymenuslist;

import xyz.dsemikin.skinnycat.guiswing.gui.daymenudetails.DayMenuDetailsFrame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class DayMenusList {

    private final JPanel contentPane;

    public DayMenusList() {

        contentPane = new JPanel();

        contentPane.setLayout(new GridBagLayout());

        final JTable dayMenusTable = new JTable(); // TODO: We need model and scroller here
        dayMenusTable.setFillsViewportHeight(true);
        final JScrollPane scrollPane = new JScrollPane(dayMenusTable);
        final GridBagConstraints dayMenusTableConstraints = new GridBagConstraints();
        dayMenusTableConstraints.gridx = 0;
        dayMenusTableConstraints.gridy = 0;
        dayMenusTableConstraints.weightx = 1.0;
        dayMenusTableConstraints.weighty = 1.0;
        dayMenusTableConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(scrollPane, dayMenusTableConstraints);


        final DayMenuDetailsFrame dayMenuDetails = new DayMenuDetailsFrame();
        final GridBagConstraints dayMenuDetailsConstraints = new GridBagConstraints();
        dayMenuDetailsConstraints.gridx = 0;
        dayMenuDetailsConstraints.gridy = 1;
        dayMenuDetailsConstraints.weightx = 1.0;
        dayMenuDetailsConstraints.weighty = 1.0;
        dayMenuDetailsConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(dayMenuDetails.rootPane(), dayMenuDetailsConstraints);
    }

    public JPanel rootPane() {
        return contentPane;
    }
}
