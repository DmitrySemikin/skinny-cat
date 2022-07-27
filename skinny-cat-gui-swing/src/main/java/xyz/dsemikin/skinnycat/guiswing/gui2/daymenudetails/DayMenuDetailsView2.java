package xyz.dsemikin.skinnycat.guiswing.gui2.daymenudetails;

import xyz.dsemikin.skinnycat.guiswing.gui2.GuiConstants;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class DayMenuDetailsView2 {

    private static final int MARGIN = GuiConstants.MARGIN;

    private final JPanel contentPanel;
    private final JTextField nameTextField;
    private final JTextField descriptionTextField;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JTable detailsTable;

    public DayMenuDetailsView2() {

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());

        final var nameLabel = new JLabel("Name:");
        final var nameLabelConstraints = new GridBagConstraints();
        nameLabelConstraints.gridx = 0;
        nameLabelConstraints.gridy = 0;
        nameLabelConstraints.weightx = 0.0;
        nameLabelConstraints.weighty = 0.0;
        nameLabelConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(nameLabel, nameLabelConstraints);

        nameTextField = new JTextField();
        final var nameTextFieldConstraints = new GridBagConstraints();
        nameTextFieldConstraints.gridx = nameLabelConstraints.gridx + 1;
        nameTextFieldConstraints.gridy = nameLabelConstraints.gridy;
        nameTextFieldConstraints.weightx = 1.0;
        nameTextFieldConstraints.weighty = 0.0;
        nameTextFieldConstraints.fill = GridBagConstraints.HORIZONTAL;
        nameTextFieldConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(nameTextField, nameTextFieldConstraints);

        final var descriptionLabel = new JLabel("Description:");
        final var descriptionLabelConstraints = new GridBagConstraints();
        descriptionLabelConstraints.gridx = nameTextFieldConstraints.gridx + 1;
        descriptionLabelConstraints.gridy = nameTextFieldConstraints.gridy;
        descriptionLabelConstraints.weightx = 0.0;
        descriptionLabelConstraints.weighty = 0.0;
        descriptionLabelConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(descriptionLabel, descriptionLabelConstraints);

        descriptionTextField = new JTextField();
        final var descriptionTextFieldConstraint = new GridBagConstraints();
        descriptionTextFieldConstraint.gridx = descriptionLabelConstraints.gridx + 1;
        descriptionTextFieldConstraint.gridy = descriptionLabelConstraints.gridy;
        descriptionTextFieldConstraint.weightx = 1.0;
        descriptionTextFieldConstraint.weighty = 0.0;
        descriptionTextFieldConstraint.fill = GridBagConstraints.HORIZONTAL;
        descriptionTextFieldConstraint.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(descriptionTextField, descriptionTextFieldConstraint);

        addButton = new JButton("Add");
        final var addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.gridx = descriptionTextFieldConstraint.gridx + 1;
        addButtonConstraints.gridy = descriptionTextFieldConstraint.gridy;
        addButtonConstraints.weightx = 0.0;
        addButtonConstraints.weighty = 0.0;
        addButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(addButton, addButtonConstraints);

        deleteButton = new JButton("Delete");
        final var deleteButtonConstraints = new GridBagConstraints();
        deleteButtonConstraints.gridx = addButtonConstraints.gridx + 1;
        deleteButtonConstraints.gridy = addButtonConstraints.gridy;
        deleteButtonConstraints.weightx = 0.0;
        deleteButtonConstraints.weighty = 0.0;
        deleteButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(deleteButton, deleteButtonConstraints);

        detailsTable = new JTable();
        detailsTable.setFillsViewportHeight(true);
        final var scrollPane = new JScrollPane(detailsTable);
        final var detailsTableConstraints = new GridBagConstraints();
        detailsTableConstraints.gridx = nameLabelConstraints.gridx;
        detailsTableConstraints.gridy = nameLabelConstraints.gridy + 1;
        detailsTableConstraints.weightx = 1.0;
        detailsTableConstraints.weighty = 1.0;
        detailsTableConstraints.gridwidth = 6;
        detailsTableConstraints.fill = GridBagConstraints.BOTH;
        detailsTableConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(scrollPane, detailsTableConstraints);
    }

    public JPanel contentPanel() {
        return contentPanel;
    }

    public JTextField nameTextField() {
        return nameTextField;
    }

    public JTextField descriptionTextField() {
        return descriptionTextField;
    }

    public JButton addButton() {
        return addButton;
    }

    public JButton deleteButton() {
        return deleteButton;
    }

    public JTable detailsTable() {
        return detailsTable;
    }

}
