package xyz.dsemikin.skinnycat.guiswing.gui.foodstuff;

import data.Foodstuff;
import data.FoodstuffUnit;
import xyz.dsemikin.skinnycat.guiswing.logic.FoodstuffController;

import javax.swing.table.AbstractTableModel;
import java.util.List;

class FoodstuffTableModel extends AbstractTableModel {

    private static final int NAME_COLUMN_IDX = 0;
    private static final int UNIT_COLUMN_IDX = 1;

    private final FoodstuffController controller;
    private List<Long> ids;

    public FoodstuffTableModel() {
        controller = new FoodstuffController();
        ids = controller.allIds();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex) {
            case NAME_COLUMN_IDX -> String.class;
            case UNIT_COLUMN_IDX -> FoodstuffUnit.class;
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
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
            case NAME_COLUMN_IDX -> foodstuff.name();
            case UNIT_COLUMN_IDX -> foodstuff.unit().toString();
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case NAME_COLUMN_IDX -> "Name";
            case UNIT_COLUMN_IDX -> "Unit";
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + column);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case NAME_COLUMN_IDX ->
                controller.setName(ids.get(rowIndex), (String) aValue);
            case UNIT_COLUMN_IDX -> {
                assert aValue instanceof FoodstuffUnit;
                controller.setUnit(ids.get(rowIndex), (FoodstuffUnit) aValue);
            }
            default -> throw new IllegalArgumentException("columnIndex must be 0 or 1, but it is " + columnIndex);
        }
        refreshData();
    }

    private void refreshData() {
        ids = controller.allIds();
        // Theoretically we could use more efficient ways,
        // but performance in not a concern in this case
        fireTableDataChanged();
    }

}
