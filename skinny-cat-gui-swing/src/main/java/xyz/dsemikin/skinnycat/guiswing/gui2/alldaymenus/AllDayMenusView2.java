package xyz.dsemikin.skinnycat.guiswing.gui2.alldaymenus;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class AllDayMenusView2 {

    private final JPanel contentPanel;
    private final JTable dayMenusTable;
    private final JButton addButon;
    private final JButton deleteButton;

    private static final int MARGIN = 5;


    public AllDayMenusView2() {

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());

        addButon = new JButton("Add");
        final var addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.gridx = 0;
        addButtonConstraints.gridy = 0;
        addButtonConstraints.weightx = 0.0;
        addButtonConstraints.weighty = 0.0;
        addButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(addButon, addButtonConstraints);

        deleteButton = new JButton("Delete");
        final var deleteButtonConstraints = new GridBagConstraints();
        deleteButtonConstraints.gridx = addButtonConstraints.gridx + 1;
        deleteButtonConstraints.gridy = addButtonConstraints.gridy;
        deleteButtonConstraints.weightx = 0.0;
        deleteButtonConstraints.weighty = 0.0;
        deleteButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(deleteButton, deleteButtonConstraints);

        dayMenusTable = new JTable();
        dayMenusTable.setFillsViewportHeight(true);
        final var scrollPane = new JScrollPane(dayMenusTable);
        final var dayMenusTableConstrains = new GridBagConstraints();
        dayMenusTableConstrains.gridx = addButtonConstraints.gridx;
        dayMenusTableConstrains.gridy = addButtonConstraints.gridy + 1;
        dayMenusTableConstrains.gridwidth = 3;
        dayMenusTableConstrains.weightx = 1.0;
        dayMenusTableConstrains.weighty = 1.0;
        dayMenusTableConstrains.fill = GridBagConstraints.BOTH;
        dayMenusTableConstrains.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(scrollPane, dayMenusTableConstrains);

    }


    public JButton addButton() {
        return addButon;
    }

    public JButton deleteButton() {
        return deleteButton;
    }

    public JTable dayMenusTable() {
        return dayMenusTable;
    }

    public JPanel contentPanel() {
        return contentPanel;
    }
}
