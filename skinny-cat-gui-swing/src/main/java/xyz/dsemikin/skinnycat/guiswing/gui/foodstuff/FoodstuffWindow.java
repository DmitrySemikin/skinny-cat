package xyz.dsemikin.skinnycat.guiswing.gui.foodstuff;

import data.FoodstuffUnit;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.TableColumn;

public class FoodstuffWindow {

    private final JFrame frame;

    public FoodstuffWindow() {
        frame = new JFrame("Foodstuff Editor");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        final JTable table = new JTable(new FoodstuffTableModel());
        table.setFillsViewportHeight(true);

        // TODO: Can we do it inside table model? Should we do it there? Probably yes
        JComboBox<FoodstuffUnit> comboBox = new JComboBox<>();
        comboBox.addItem(FoodstuffUnit.UNIT);
        comboBox.addItem(FoodstuffUnit.GRAM);

        final TableColumn unitColumn = table.getColumnModel().getColumn(1);
        unitColumn.setCellEditor(new DefaultCellEditor(comboBox));

        final JScrollPane scrollPane = new JScrollPane(table);

        frame.add(scrollPane);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

}

