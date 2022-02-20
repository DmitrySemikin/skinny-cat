package xyz.dsemikin.skinnycat.guiswing.gui.daymenudetails;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/** View of the DayMenuDetailsPanel GUI element. Responsible for visual presentation and "visual behavior" (resizing, tab sequence etc.) */
public class DayMenuDetailsPanelView {

    private final JPanel rootPane;

    private final JTextField nameText;
    private final JTextField descriptionText;
    private final JTable foodstuffTable;

    public DayMenuDetailsPanelView() {
        rootPane = new JPanel();

        rootPane.setLayout(new GridBagLayout());

        final JLabel nameLabel = new JLabel("Name");
        final GridBagConstraints nameLabelConstraints = new GridBagConstraints();
        nameLabelConstraints.gridx = 0;
        nameLabelConstraints.gridy = 0;
        nameLabelConstraints.weightx = 0.0;
        nameLabelConstraints.weighty = 0.0;
        rootPane.add(nameLabel, nameLabelConstraints);

        nameText = new JTextField();
        final GridBagConstraints nameTextConstraints = new GridBagConstraints();
        nameTextConstraints.gridx = 1;
        nameTextConstraints.gridy = 0;
        nameTextConstraints.weightx = 1.0;
        nameTextConstraints.weighty = 0.0;
        nameTextConstraints.fill = GridBagConstraints.HORIZONTAL;
        rootPane.add(nameText, nameTextConstraints);

        final JLabel descriptionLabel = new JLabel("Description:");
        final GridBagConstraints menuLabelConstraints = new GridBagConstraints();
        menuLabelConstraints.gridx = 0;
        menuLabelConstraints.gridy = 1;
        menuLabelConstraints.weightx = 0.0;
        menuLabelConstraints.weighty = 0.0;
        rootPane.add(descriptionLabel, menuLabelConstraints);

        descriptionText = new JTextField();
        final GridBagConstraints menuTextConstraints = new GridBagConstraints();
        menuTextConstraints.gridx = 1;
        menuTextConstraints.gridy = 1;
        menuTextConstraints.weightx = 1.0;
        menuTextConstraints.weighty = 0.0;
        menuTextConstraints.fill = GridBagConstraints.HORIZONTAL;
        rootPane.add(descriptionText, menuTextConstraints);

        // TODO: we need model here
        foodstuffTable = new JTable();
        foodstuffTable.setFillsViewportHeight(true);
        final JScrollPane scrollPane = new JScrollPane(foodstuffTable);
        final GridBagConstraints foodstuffTableConstraints = new GridBagConstraints();
        foodstuffTableConstraints.gridx = 0;
        foodstuffTableConstraints.gridy = 2;
        foodstuffTableConstraints.gridwidth = 2;
        foodstuffTableConstraints.weightx = 1.0;
        foodstuffTableConstraints.weighty = 1.0;
        foodstuffTableConstraints.fill = GridBagConstraints.BOTH;
        rootPane.add(scrollPane, foodstuffTableConstraints);
    }

    public JPanel rootPanel() {
        return rootPane;
    }

    public JTextField nameText() {
        return nameText;
    }

    public JTextField descriptionText() {
        return descriptionText;
    }

    public JTable getFoodstuffTable() {
        return foodstuffTable;
    }
}
