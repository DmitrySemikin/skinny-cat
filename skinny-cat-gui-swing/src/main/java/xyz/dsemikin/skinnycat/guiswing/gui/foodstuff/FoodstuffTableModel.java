package xyz.dsemikin.skinnycat.guiswing.gui.foodstuff;

import data.Foodstuff;
import xyz.dsemikin.skinnycat.guiswing.logic.FoodstuffController;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class FoodstuffTableModel extends AbstractTableModel {

    private final FoodstuffController controller;
    private final List<Long> ids;

    public FoodstuffTableModel() {
        controller = new FoodstuffController();
        ids = controller.allIds();
    }

    @Override
    public int getRowCount() {
        return ids.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final Foodstuff foodstuff = controller.get(ids.get(rowIndex));
        return switch(columnIndex) {
            case 0 -> foodstuff.name();
            case 1 -> foodstuff.unit().toString();
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case 0 -> "Name";
            case 1 -> "Unit";
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + column);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return super.isCellEditable(rowIndex, columnIndex);
    }
}
