package xyz.dsemikin.skinnycat.guiswing.gui.daymenudetails;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class DayMenuDetailsPane {

    private final JPanel contentPane;

    public DayMenuDetailsPane() {
        contentPane = new JPanel();

        contentPane.setLayout(new GridBagLayout());


        final JLabel nameLabel = new JLabel("Name");
        final GridBagConstraints nameLabelConstraints = new GridBagConstraints();
        nameLabelConstraints.gridx = 0;
        nameLabelConstraints.gridy = 0;
        nameLabelConstraints.weightx = 0.0;
        nameLabelConstraints.weighty = 0.0;
        contentPane.add(nameLabel, nameLabelConstraints);


        final JTextField nameText = new JTextField();
        final GridBagConstraints nameTextConstraints = new GridBagConstraints();
        nameTextConstraints.gridx = 1;
        nameTextConstraints.gridy = 0;
        nameTextConstraints.weightx = 1.0;
        nameTextConstraints.weighty = 0.0;
        nameTextConstraints.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(nameText, nameTextConstraints);


        final JLabel menuLabel = new JLabel("Menu:");
        final GridBagConstraints menuLabelConstraints = new GridBagConstraints();
        menuLabelConstraints.gridx = 0;
        menuLabelConstraints.gridy = 1;
        menuLabelConstraints.weightx = 0.0;
        menuLabelConstraints.weighty = 0.0;
        contentPane.add(menuLabel, menuLabelConstraints);


        final JTextField menuText = new JTextField();
        final GridBagConstraints menuTextConstraints = new GridBagConstraints();
        menuTextConstraints.gridx = 1;
        menuTextConstraints.gridy = 1;
        menuTextConstraints.weightx = 1.0;
        menuTextConstraints.weighty = 0.0;
        menuTextConstraints.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(menuText, menuTextConstraints);


        final JTable foodstuffTable = new JTable(); // TODO: we need model here
        foodstuffTable.setFillsViewportHeight(true);
        final JScrollPane scrollPane = new JScrollPane(foodstuffTable);
        final GridBagConstraints foodstuffTableConstraints = new GridBagConstraints();
        foodstuffTableConstraints.gridx = 0;
        foodstuffTableConstraints.gridy = 2;
        foodstuffTableConstraints.gridwidth = 2;
        foodstuffTableConstraints.weightx = 1.0;
        foodstuffTableConstraints.weighty = 1.0;
        foodstuffTableConstraints.fill = GridBagConstraints.BOTH;
        contentPane.add(scrollPane, foodstuffTableConstraints);


//        frame.pack();
//        frame.setVisible(true);
    }

    public JPanel rootPane() {
        return contentPane;
    }
}
