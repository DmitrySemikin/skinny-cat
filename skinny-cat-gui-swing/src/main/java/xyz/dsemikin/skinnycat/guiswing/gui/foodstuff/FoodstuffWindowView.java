package xyz.dsemikin.skinnycat.guiswing.gui.foodstuff;

import xyz.dsemikin.skinnycat.data.FoodstuffUnit;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.TableColumn;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class FoodstuffWindowView {

    private final JButton addButton;
    private final JButton deleteButton;
    private final JTable table;

    public FoodstuffWindowView(final FoodstuffTableModel tableModel) {
        JFrame frame = new JFrame("Foodstuff Editor");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        final Container contentPane = frame.getContentPane();
        contentPane.setLayout(new GridBagLayout());


        addButton = new JButton("Add");
        final GridBagConstraints addButtonConstraints = new GridBagConstraints();
        addButtonConstraints.gridx = 0;
        addButtonConstraints.gridy = 0;
        contentPane.add(addButton, addButtonConstraints);

        deleteButton = new JButton("Delete");
        final GridBagConstraints deleteButtonConstraints = new GridBagConstraints();
        deleteButtonConstraints.gridx = 1;
        deleteButtonConstraints.gridy = 0;
        contentPane.add(deleteButton, deleteButtonConstraints);


        table = new JTable(tableModel);
        table.setFillsViewportHeight(true);

        // TODO: Can we do it inside table model? Should we do it there? Probably yes
        JComboBox<FoodstuffUnit> comboBox = new JComboBox<>();
        comboBox.addItem(FoodstuffUnit.UNIT);
        comboBox.addItem(FoodstuffUnit.GRAM);

        final TableColumn unitColumn = table.getColumnModel().getColumn(1);
        unitColumn.setCellEditor(new DefaultCellEditor(comboBox));

        final JScrollPane scrollPane = new JScrollPane(table);

        final GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        contentPane.add(scrollPane, constraints);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public JButton addButton() {
        return addButton;
    }

    public JButton deleteButton() {
        return deleteButton;
    }

    public JTable table() {
        return table;
    }
}

