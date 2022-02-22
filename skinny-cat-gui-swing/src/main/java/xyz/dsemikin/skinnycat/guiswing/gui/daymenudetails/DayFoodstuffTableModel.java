package xyz.dsemikin.skinnycat.guiswing.gui.daymenudetails;

import xyz.dsemikin.skinnycat.data.Foodstuff;
import xyz.dsemikin.skinnycat.data.FoodstuffUse;
import xyz.dsemikin.skinnycat.guiswing.logic.DayMenuDetailsController;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class DayFoodstuffTableModel extends AbstractTableModel {

    private static final int FOODSTUFF_COLUMN_IDX = 0;
    private static final int QUANTITY_COLUMN_IDX = 1;
    private static final int COLUMN_COUNT = 2; // one after the latest real one.

    private final DayMenuDetailsController controller;

    // in this case it is not IDs of objects, but rather indices
    // in the array of controller. It could be used to simplify the structures,
    // but we will not do it
    private List<Long> ids;

    public DayFoodstuffTableModel(final DayMenuDetailsController controller) {
        this.controller = controller;
        ids = controller.allFoodstuffUsesIds();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch(columnIndex) {
            case FOODSTUFF_COLUMN_IDX -> Foodstuff.class;
            case QUANTITY_COLUMN_IDX -> Double.class;
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
    }

    @Override
    public int getRowCount() {
        return ids.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        final FoodstuffUse foodstuffUse = controller.getFoodstuffUse(ids.get(rowIndex));
        return switch(columnIndex) {
            case FOODSTUFF_COLUMN_IDX -> foodstuffUse.foodstuff().name() + "(" + foodstuffUse.foodstuff().unit().toString() + ")";
            case QUANTITY_COLUMN_IDX -> foodstuffUse.quantity();
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + columnIndex);
        };
    }

    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case FOODSTUFF_COLUMN_IDX -> "Foodstuff";
            case QUANTITY_COLUMN_IDX -> "Quantity";
            default -> throw new IllegalArgumentException("Must be 0 or 1, but it is " + column);
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        // TODO
        switch (columnIndex) {
            case FOODSTUFF_COLUMN_IDX -> controller.setFoodstuff(ids.get(rowIndex), (Foodstuff) aValue);
            case QUANTITY_COLUMN_IDX -> controller.setQuantity(ids.get(rowIndex), (Double)aValue);
            default -> throw new IllegalArgumentException("columnIndex must be 0 or 1, but it is " + columnIndex);
        }
        refreshData();
    }

    public void refreshData() {
        ids = controller.allFoodstuffUsesIds();
        // Theoretically we could use more efficient ways,
        // but performance in not a concern in this case
        fireTableDataChanged();
    }
}
