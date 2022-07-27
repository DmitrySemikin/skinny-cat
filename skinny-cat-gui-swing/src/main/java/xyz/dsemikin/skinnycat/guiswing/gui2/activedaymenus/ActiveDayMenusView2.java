package xyz.dsemikin.skinnycat.guiswing.gui2.activedaymenus;

import xyz.dsemikin.skinnycat.guiswing.gui2.GuiConstants;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ActiveDayMenusView2 {

    private static final int MARGIN = GuiConstants.MARGIN;

    private final JPanel contentPanel;
    private final JTable activeMenusTable;
    private final JButton addButton;
    private final JButton deleteButton;
    private final JButton upButton;
    private final JButton downButton;

    public ActiveDayMenusView2() {

        contentPanel = new JPanel();
        contentPanel.setLayout(new GridBagLayout());

        addButton = new JButton("Add");
        final var addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.gridx = 0;
        addButtonConstraints.gridy = 0;
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

        upButton = new JButton("Up");
        final var upButtonConstraints = new GridBagConstraints();
        upButtonConstraints.gridx = deleteButtonConstraints.gridx + 1;
        upButtonConstraints.gridy = deleteButtonConstraints.gridy;
        upButtonConstraints.weightx = 0.0;
        upButtonConstraints.weighty = 0.0;
        upButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(upButton, upButtonConstraints);

        downButton = new JButton("Down");
        final var downButtonConstraints = new GridBagConstraints();
        downButtonConstraints.gridx = upButtonConstraints.gridx + 1;
        downButtonConstraints.gridy = upButtonConstraints.gridy;
        downButtonConstraints.weightx = 0.0;
        downButtonConstraints.weighty = 0.0;
        downButtonConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(downButton, downButtonConstraints);

        activeMenusTable = new JTable();
        activeMenusTable.setFillsViewportHeight(true);
        final var scrollPane = new JScrollPane(activeMenusTable);
        final var activeMenusTableConstraints = new GridBagConstraints();
        activeMenusTableConstraints.gridx = addButtonConstraints.gridx;
        activeMenusTableConstraints.gridy = addButtonConstraints.gridy + 1;
        activeMenusTableConstraints.gridwidth = 5;
        activeMenusTableConstraints.weightx = 1.0;
        activeMenusTableConstraints.weighty = 1.0;
        activeMenusTableConstraints.fill = GridBagConstraints.BOTH;
        activeMenusTableConstraints.insets = new Insets(MARGIN, MARGIN, MARGIN, MARGIN);
        contentPanel.add(scrollPane, activeMenusTableConstraints);
    }

    public JPanel contentPanel() {
        return contentPanel;
    }

    public JTable activeMenusTable() {
        return activeMenusTable;
    }

    public JButton addButton() {
        return addButton;
    }

    public JButton deleteButton() {
        return deleteButton;
    }

    public JButton upButton() {
        return upButton;
    }

    public JButton downButton() {
        return downButton;
    }
}
